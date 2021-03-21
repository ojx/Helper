class Letter {
    private boolean terminal;
    private Letter[] letters;

    Letter(String word) {
        letters = new Letter[28];
        terminal = false;

        add(word);
    }

    Letter() {
        terminal = true;
    }

    void add(String word) {
        if (word.length() == 1) {
            terminal = true;

        } else if (word.length() > 1) {
            int index = word.charAt(0) == '-' ? 0 : word.charAt(0) - 96;

            if (letters[index] == null) {
                letters[index] = new Letter(word.substring(1));
            } else {
                letters[index].add(word.substring(1));
            }
        }

    }

    public boolean isTerminal() {
        return terminal;
    }


    public boolean check(String word) {
        if (word.length() == 0)
            return false;

        int index = word.charAt(0) == '-' ? 0 : word.charAt(0) - 96;

        if (letters[index] == null)
            return false;

        if (word.length() == 1 && letters[index].isTerminal())
            return true;

        return letters[index].check(word.substring(1));
    }
}
