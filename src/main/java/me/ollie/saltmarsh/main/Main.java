package me.ollie.saltmarsh.main;

public class Main {

    public static void main(String[] args) {
        validateArgs(args);

        Saltmarsh saltmarsh = new Saltmarsh(args[0]);

        saltmarsh.init();
        saltmarsh.run();
    }

    private static void validateArgs(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Must have token as first argument!");
    }
}
