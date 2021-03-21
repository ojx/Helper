import java.util.ArrayList;
import java.util.List;


public abstract class Helper {
    private static final int MAX_INT = 30, MIN_INT = -10;


    /*****************************************************************************
     * Helper Methods
     *****************************************************************************/

    public static int[][] copy2DIntArray(int[][] matrix) {
        int[][] m = new int[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                m[r][c] = matrix[r][c];
            }
        }

        return m;
    }

    public static ArrayList<String> copyStringList(List<String> list) {
        ArrayList<String> l = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            l.add(list.get(i));
        }

        return l;
    }

    public static int[] generateIntArray(int length) {
        return generateIntArray(length, length);
    }

    public static int[] generateIntArray(int minLength, int maxLength) {
        return generateIntArray(minLength, maxLength, MIN_INT, MAX_INT);
    }

    public static int[] generateIntArray(int minLength, int maxLength, int min, int max) {
        int length = (int)(Math.random() * (maxLength - minLength + 1)) + minLength;

        int[] a = new int[length];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * (max - min + 1)) + min;
        }

        return a;
    }

    public static double[] generateDoubleArray(int length) {
        return generateDoubleArray(length, length);
    }

   public static double[] generateDoubleArray(int minLength, int maxLength) {
        return generateDoubleArray(minLength, maxLength, MIN_INT, MAX_INT);
    }

    public static double[] generateDoubleArray(int minLength, int maxLength, int min, int max) {
        int length = (int)(Math.random() * (maxLength - minLength + 1)) + minLength;

        double[] a = new double[length];

        for (int i = 0; i < a.length; i++) {
            do {
                a[i] = (int) (Math.random() * (max - min + 1) * 10) / 10.0 + min;
            } while ((a[i]+"").length() > 10);
        }

        return a;
    }

    public static String[] generateStringArray(int length) {
        return generateStringArray(length, length);
    }

    public static String[] generateStringArray(int minLength, int maxLength) {
        int length = (int)(Math.random() * (maxLength - minLength + 1)) + minLength;

        String[] a = new String[length];

        for (int i = 0; i < a.length; i++) {
            a[i] = Dictionary.getRandom();
        }

        return a;
    }


    public static String[] generateStringArray(int minLength, int maxLength, int min, int max) {
        int length = (int)(Math.random() * (maxLength - minLength + 1)) + minLength;

        String[] a = new String[length];

        for (int i = 0; i < a.length; i++) {
            a[i] = Dictionary.getRandom(min, max);
        }

        return a;
    }

    public static int[][] generateRandomMatrix(int minRows, int maxRows, int minCols, int maxCols) {
        return generateRandomMatrix(minRows, maxRows, minCols, maxCols, MIN_INT, MAX_INT);
    }

    public static int[][] generateRandomMatrix(int minRows, int maxRows, int minCols, int maxCols, int min, int max) {
        int[][] mat = new int[(int)(Math.random() * (maxRows - minRows + 1))+minRows][(int)(Math.random() * (maxCols - minCols + 1))+minCols];

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                mat[r][c] = (int)(Math.random() * (max - min + 1)) + min;
            }
        }

        return mat;
    }


   public static double[][] generateRandomDoubleMatrix(int minRows, int maxRows, int minCols, int maxCols) {
        double[][] mat = new double[(int)(Math.random() * (maxRows - minRows + 1))+minRows][(int)(Math.random() * (maxCols - minCols + 1))+minCols];

        for (int r = 0; r < mat.length; r++) {
            mat[r] = generateDoubleArray(mat[r].length);
        }

        return mat;
    }

    public static String[][] generateRandomStringMatrix(int minRows, int maxRows, int minCols, int maxCols, int minLength, int maxLength) {
        String[][] mat = new String[(int)(Math.random() * (maxRows - minRows + 1))+minRows][(int)(Math.random() * (maxCols - minCols + 1))+minCols];

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (minLength == 1 && maxLength == 1) {
                    mat[r][c] = "" + (char)((Math.random() * 26) + 65);
                } else {
                    mat[r][c] = Dictionary.getRandom(minLength, maxLength);
                }
            }
        }

        return mat;
    }

    public static String toStr(int[] a) {
        return arrayIntToString(a);
    }

    public static String toStr(double[] a) {
        return arrayDoubleToString(a);
    }

    public static String toStr(String[] a) {
        return arrayStringToString(a);
    }

    public static String toStr(int[][] a) {
        return array2DIntToString(a);
    }

    public static String toStr(double[][] a) {
        return array2DDoubleToString(a);
    }

    public static String toStr(String[][] a) {
        return array2DStringToString(a);
    }

    public static String toStr(List list) {
        if (list.size() > 0 && list.get(0) instanceof String) {
            return listStringToDisplayString(list);
        }
        return listIntToDisplayString(list);
    }

    public static void print(int[] a) {
        System.out.println(toStr(a));
    }

    public static void print(double[] a) {
        System.out.println(toStr(a));
    }

    public static void print(String[] a) {
        System.out.println(toStr(a));
    }

    public static void print(int[][] a) {
        System.out.println(toStr(a));
    }

    public static void print(double[][] a) {
        System.out.println(toStr(a));
    }

    public static void print(String[][] a) {
        System.out.println(toStr(a));
    }

    public static void print(List list) {
        System.out.println(toStr(list));
    }

    public static String arrayIntToString(int[] a) {
        String s = "{";

        for (int i = 0; i < a.length; i++) {
            s += a[i];

            if (i < a.length - 1)
                s += ", ";
        }

        s += "}";

        return s;
    }

    public static String arrayIntToBasicString(int[] a) {
        String s = "";

        for (int i = 0; i < a.length; i++) {
            s += a[i];

            if (i < a.length - 1)
                s += " ";
        }

        return s;
    }

     public static String listIntToDeclareString(List<Integer> list) {
        //List<Type> obj = new ArrayList<>(
         //        List.of(Obj A, Obj B, Obj C, ....so on));
        String s = "new ArrayList<>(List.of(";

        for (int i = 0; i < list.size(); i++) {
            s += list.get(i);

            if (i < list.size() - 1)
                s += ", ";
        }

        s += "));";

        return s;
    }

     public static String listStringToDeclareString(List<String> list) {
        //List<Type> obj = new ArrayList<>(
         //        List.of(Obj A, Obj B, Obj C, ....so on));
        String s = "new ArrayList<>(List.of(";

        for (int i = 0; i < list.size(); i++) {
            s += "\"" + list.get(i) + "\"";

            if (i < list.size() - 1)
                s += ", ";
        }

        s += "));";

        return s;
    }

     public static String listIntToDisplayString(List<Integer> list) {
        //List<Type> obj = new ArrayList<>(
         //        List.of(Obj A, Obj B, Obj C, ....so on));
        String s = "[";

        for (int i = 0; i < list.size(); i++) {
            s += list.get(i);

            if (i < list.size() - 1)
                s += ", ";
        }

        s += "]";

        return s;
    }

     public static String listStringToDisplayString(List<String> list) {
        //List<Type> obj = new ArrayList<>(
         //        List.of(Obj A, Obj B, Obj C, ....so on));
        String s = "[";

        for (int i = 0; i < list.size(); i++) {
            s += "\"" +  list.get(i) + "\"";

            if (i < list.size() - 1)
                s += ", ";
        }

        s += "]";

        return s;
    }

    public static String array2DIntToStringFull(int[][] a) {
        String s = "magicSquare(new int[][]{ ";

        for (int i = 0; i < a.length; i++) {
            s += arrayIntToString(a[i]);

            if (i < a.length - 1)
                s += ",\n                         ";
        }

        s += " })";

        return s;
    }

    public static String array2DIntToString(int[][] a) {
        String s = "{ ";

        for (int i = 0; i < a.length; i++) {
            s += arrayIntToString(a[i]);

            if (i < a.length - 1)
                s += ",\n  ";
        }

        s += " }";

        return s;
    }
    public static String array2DIntToStringMM(int[][] a) {
        String s = "minMaxRows(new int[][]{ ";

        for (int i = 0; i < a.length; i++) {
            s += arrayIntToString(a[i]);

            if (i < a.length - 1)
                s += ",\n                        ";
        }

        s += " })";

        return s;
    }

    public static String array2DIntToBasicString(int[][] a) {
        String s = "";

        for (int i = 0; i < a.length; i++) {
            s += arrayIntToBasicString(a[i]);

            if (i < a.length - 1)
                s += "\n";
        }

        return s;
    }

      public static String array2DDoubleToString(double[][] a) {
        String s = "{ ";

        for (int i = 0; i < a.length; i++) {
            s += arrayDoubleToString(a[i]);

            if (i < a.length - 1)
                s += ",\n  ";
        }

        s += " }";

        return s;
    }

    public static String arrayDoubleToString(double[] a) {
        String s = "{";

        for (int i = 0; i < a.length; i++) {
            s += a[i];

            if (i < a.length - 1)
                s += ", ";
        }

        s += "}";

        return s;
    }

    public static String arrayStringToString(String[] a) {
        String s = "{";

        for (int i = 0; i < a.length; i++) {
            s += "\"" + a[i] + "\"";

            if (i < a.length - 1)
                s += ", ";
        }

        s += "}";

        return s;
    }

    public static String array2DStringToString(String[][] a) {
        String s = "{ ";

        for (int i = 0; i < a.length; i++) {
            s += arrayStringToString(a[i]);

            if (i < a.length - 1)
                s += ",\n  ";
        }

        s += " }";

        return s;
    }

    public static ArrayList<Integer> arrayToListInt(int[] a) {
        ArrayList<Integer> list = new ArrayList<>(a.length);

        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        return list;
    }

    public static ArrayList<String> arrayToListString(String[] a) {
        ArrayList<String> list = new ArrayList<>(a.length);

        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        return list;
    }

    public static int[] listToArrayInt(ArrayList<Integer> list) {
        int[] a = new int[list.size()];

        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }

        return a;
    }

}
