public class Matrix {
    private static final int MAX_INT = 30, MIN_INT = -10;

    public static void print(int[][] mat) {
        System.out.println(array2DIntToString(mat));
    }

    public static int[][] generate(int minRows, int maxRows, int minCols, int maxCols) {
        return generate(minRows, maxRows, minCols, maxCols, MIN_INT, MAX_INT);
    }

    public static int[][] generate(int minRows, int maxRows, int minCols, int maxCols, int min, int max) {
        int[][] mat = new int[(int)(Math.random() * (maxRows - minRows + 1))+minRows][(int)(Math.random() * (maxCols - minCols + 1))+minCols];

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                mat[r][c] = (int)(Math.random() * (max - min + 1)) + min;
            }
        }

        return mat;
    }


    private static String arrayIntToString(int[] a) {
        String s = "{";

        for (int i = 0; i < a.length; i++) {
            s += a[i];

            if (i < a.length - 1)
                s += ", ";
        }

        s += "}";

        return s;
    }

    private static int[][] copy2DIntArray(int[][] matrix) {
        int[][] m = new int[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                m[r][c] = matrix[r][c];
            }
        }

        return m;
    }

    private static String array2DIntToString(int[][] a) {
        String s = "{ ";

        for (int i = 0; i < a.length; i++) {
            s += arrayIntToString(a[i]);

            if (i < a.length - 1)
                s += ",\n  ";
        }

        s += " }";

        return s;
    }
}