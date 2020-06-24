package interviewQuestions.glovo;

public class DamaniListOfCountries {

    public static void main(String []args){
        // int m[][] = new int[][] {
        //     {5,4,4},
        //     {4,3,4},
        //     {3,2,4},
        //     {2,2,2},
        //     {3,3,4},
        //     {1,4,4},
        //     {4,1,1}
        // };
        int m[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        int row = m.length;
        int col = m[0].length;
        int size = row * col;
        if(size == 1) {
            System.out.println(1);
        } else {
            int [] b = new int[size];
            solution(m, b, row, col, 1);
            int count = 0;
            for(int i=0; i<size; i++) {
                if(count < b[i]) count = b[i];
            }
            System.out.println(count);
        }
    }
    public static void solution(int[][] a, int[] b, int row, int col, int c) {
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++) {
                boolean m = markAndTraverse(a, b, row, col, i, j, c);
                if(m) c++;
            }
        }
    }
    public static boolean markAndTraverse(int [][] a, int[] b, int row, int col, int i, int j, int c) {
        boolean mark = false;
        int index = getIndex(a[0].length, i, j);
        if(b[index] == 0) {
            b[index] = c;
            mark = true;
            //left
            if(j > 0 && a[i][j] == a[i][j-1] && !isMarked(b, col, i, j-1)) {
                markAndTraverse(a, b, row, col, i, j-1, c);
            }
            //up
            if(i > 0 && a[i][j] == a[i-1][j] && !isMarked(b, col, i-1, j)) {
                markAndTraverse(a, b, row, col, i-1, j, c);
            }
            //right
            if(j < col-1 && a[i][j] == a[i][j+1] && !isMarked(b, col, i, j+1)) {
                markAndTraverse(a, b, row, col, i, j+1, c);
            }
            //down
            if(i < row-1 && a[i][j] == a[i+1][j]  && !isMarked(b, col, i+1, j)) {
                markAndTraverse(a, b, row, col, i+1, j, c);
            }
        }
        return mark;
    }
    public static int getIndex(int col, int i, int j) {
        return col * i + j;
    }
    public static boolean isMarked(int a[], int col, int i, int j) {
        int index = getIndex(col, i, j);
        return a[index] != 0;
    }
}
