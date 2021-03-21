import java.util.ArrayList;
import java.util.Arrays;

public abstract class Dictionary {

    private static ArrayList<Integer> usedIndicies = new ArrayList<Integer>();

    private static String[] words;

    private static Letter[] letters;

    private static final String[] keyWords = {
            "abstract",
            "continue",
            "for",
            "new",
            "switch",
            "assert",
            "default",
            "package",
            "synchronized",
            "boolean",
            "do",
            "if",
            "private",
            "this",
            "break",
            "double",
            "implements",
            "protected",
            "throw",
            "byte",
            "else",
            "import",
            "public",
            "throws",
            "case",
            "enum",
            "instanceof",
            "return",
            "transient",
            "catch",
            "extends",
            "int",
            "short",
            "try",
            "char",
            "final",
            "interface",
            "static",
            "void",
            "class",
            "finally",
            "long",
            "volatile",
            "const",
            "float",
            "native",
            "super",
            "while",
            "elif",
            "as",
            "assert",
            "def",
            "del",
            "except",
            "finally",
            "from",
            "global",
            "filter",
            "lambda",
            "pass",
            "raise",
            "with",
            "yield",
            "exec",
            "nonlocal",
            "bool",
            "complex",
            "dict",
            "enumerate",
            "frozenset",
            "list",
            "object",
            "property",
            "reversed",
            "set",
            "slice",
            "super",
            "str",
            "tuple",
            "type",
            "buffer",
            "unicode",
            "bytes",
            "filter",
            "map",
            "open",
            "range",
            "zip"
    };

    public static boolean contains(String word) {
        if (words == null) initialize();

        word = word.trim().toLowerCase();

        System.out.println("Checking: " + word);

        return containsHelper(word);

        /*
        int first = 0, last = words.length - 1;

        while (first <= last) {
            int mid = (first + last) / 2;

            //System.out.println(words[mid]);
            int comp = word.compareTo(words[mid]);

            if (comp < 0) {
                last = mid - 1;
            } else if (comp > 0) {
                first = mid + 1;
            } else
                return true;
        }

        return false;

         */
    }

    private static boolean containsHelper(String word) {
        int index = word.charAt(0) == '-' ? 0 : word.charAt(0) - 96;

        if (letters[index] == null)
            return false;

        if (word.length() == 1 && letters[index].isTerminal()) {
            return true;
        }

        return letters[index].check(word.substring(1));
    }



    public static String getRandom() {
        return getRandom(1,100);
    }

    public static String getRandom(int maxLength) {
        return getRandom(1,maxLength);
    }

    public static String getRandom(int minLength, int maxLength) {
        if (words == null) initialize();

        String word;
        int index;

        do {
            index = (int) (Math.random() * words.length);
            word = words[index].trim();
        } while (word.length() < minLength || word.length() > maxLength || isKey(word) || isUsed(index));

        usedIndicies.add(index);

        return word;
    }

    public static String getRandom(int minLength, int maxLength, int allowableCharRepetition) {
        if (words == null) initialize();

        if (allowableCharRepetition < 1) {
            return getRandom(minLength, maxLength);
        }

        String word;
        int index;

        boolean repeated = true;

        do {

            word = getRandom(minLength, maxLength);

            int[] charCount = new int[128];

            for (int i = 0; i < word.length(); i++) {

                int ascii = (int)word.charAt(i);

                if (ascii >= 0 && ascii < 128)
                        charCount[ascii]++;

            }

            repeated = false;

            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] > allowableCharRepetition) {
                    repeated = true;
                    break;
                }
            }

        } while (repeated);

        //usedIndicies.add(index);

        return word;
    }


    public static boolean isKey(String word) {
        for (int i = 0; i < keyWords.length; i++) {
            if (keyWords[i].trim().equalsIgnoreCase(word))
                return true;
        }

        return false;
    }

    private static boolean isUsed(int index) {
        return usedIndicies.contains(index);
    }

    public static boolean isValid(String word) {
        return Arrays.binarySearch(words,word.toLowerCase().trim()) >= 0;
    }

    public static void reset() {
        usedIndicies.clear();
    }


    private static void initialize() {
        String[][] w = new String[][]{
                Words1.list,
                Words2.list,
                Words3.list,
                Words4.list,
                Words5.list,
                Words6.list,
                Words7.list,
                Words8.list,
                Words9.list,
                Words10.list,
                Words11.list,
                Words12.list,
                Words13.list,
                Words14.list,
                Words15.list,
                Words16.list,
        };

        int len = 0;

        for (int r = 0; r < w.length; r++) {
            len += w[r].length;
        }

        words = new String[len];
        int i = 0;

        for (int r = 0; r < w.length; r++) {
            for (int c = 0; c < w[r].length; c++) {
                words[i++] = w[r][c];
            }
        }

    }

}
