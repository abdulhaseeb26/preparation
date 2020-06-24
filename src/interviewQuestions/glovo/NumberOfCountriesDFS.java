package interviewQuestions.glovo;

public class NumberOfCountriesDFS {

    public static void main(String [] args) {

        /*
        5   4   4
        4   3   4
        3   2   4
        2   2   2
        3   3   4
        1   4   4
        4   1   1

        * */

        int[][] matrix = new int[][]{
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1}
        };

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int numberOfCountries = 0;

        for (int row=0; row < matrix.length; row++) {
            for (int col =0; col < matrix[row].length; col++) {
                int value = matrix[row][col];
                markAllNeighbouringVisited(matrix, row, col, value, visited);
                numberOfCountries++;

            }
        }
        System.out.println(numberOfCountries);
    }

    private static void markAllNeighbouringVisited(int[][] matrix, int row, int col, int value, boolean[][] visited) {

        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) {
            return;
        }

        if (matrix[row][col] != value || visited[row][col]) {
            return;
        }

        visited[row][col] =  true;

        for (int r = row -1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++){
                if (matrix[row][col] == value)
                markAllNeighbouringVisited(matrix, r, c, value, visited);
            }
        }
    }
}
