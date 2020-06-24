package interviewQuestions.glovo;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Countries {

    public int runner(int[][] A) {
        HashSet<String> visited = new HashSet<>();
        int countries = 0;
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[i].length; j++)
            {
                Position position = new Position(i, j);
                if (!visited.contains(position.toString())) {
                    visited.add(position.toString());
                    findCountry(A, position, visited);
                    countries++;
                }
            }
        }
        return countries;
    }

    public void findCountry(int[][] matrix, Position currentPosition, HashSet<String> visited) {
        List<Position> neighborsWithSameColor = currentPosition.getNeighbors(matrix)
                .stream()
                .filter(position -> !visited.contains(position.toString()))
                .peek(position -> visited.add(position.toString()))
                .collect(Collectors.toList());
        neighborsWithSameColor.forEach(position -> findCountry(matrix, position, visited));
    }
}

class Position {
    public int row;
    public int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public List<Position> getNeighbors(int[][] matrix) {
        int color = matrix[row][column];
        return Stream.of(
                new Position(row - 1, column),
                new Position(row + 1, column),
                new Position(row, column - 1),
                new Position(row, column + 1)
        )
                .filter(position -> position.isValid(matrix))
                .filter(position -> color == matrix[position.row][position.column])
                .collect(Collectors.toList());
    }

    private boolean isValid(int[][] matrix) {
        return row >= 0 && column >= 0
                && row < matrix.length
                && column < matrix[0].length;
    }

    @Override
    public String toString() {
        return row + "," + column;
    }
}
