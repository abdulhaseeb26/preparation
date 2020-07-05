package codingCracking.arrays;

public class RotateMatirix {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int numberOfColumns = 3;
        int i=0;

        int[][] rotatedMatrix = new int[3][3];

        for (int[] row : arr) {
            for (int k =0; k < numberOfColumns; k++) {
                rotatedMatrix[k][numberOfColumns - i -1] = row[k];
            }
            i++;
        }

        printRotatedArray(rotatedMatrix);

    }

    private static void printRotatedArray(int[][] rotatedMatrix) {

        for (int[] matrix : rotatedMatrix) {
            for (int i : matrix) {
                System.out.println(i);
            }
        }
    }
}
