package interviewQuestions.zalando;

public class FindMatrix {

    // Driver Code
    public static void main(String[] args)
    {
        int row[] = { 2, 2, 2, 2, 2 };
        int column[] = { 5, 5, 0, 0 };
        int r = row.length;
        int c = column.length;

        if (matrix_exist(row, column, r, c))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean matrix_exist(int row[], int column[],
                                int r, int c) {
        int row_sum = 0;
        int column_sum = 0;
        int row_max = -1;
        int column_max = -1;
        int row_non_zero = 0;
        int column_non_zero = 0;

        // Store sum of rowsums, max of row sum
        // number of non zero row sums
        for (int i = 0; i < r; i++) {
            row_sum += row[i];
            row_max = Math.max(row_max, row[i]);
            if (row[i] > 0) {
                row_non_zero++;
            }
        }

        // Store sum of column sums, max of column sum
        // number of non zero column sums
        for (int i = 0; i < c; i++) {
            column_sum += column[i];
            column_max = Math.max(column_max, column[i]);
            if (column[i] > 0) {
                column_non_zero++;
            }
        }

        // Check condition 1, 2, 3
        if ((row_sum != column_sum)
                || (row_max > column_non_zero)
                || (column_max > row_non_zero)) {
            return false;
        }

        return true;
    }
}
