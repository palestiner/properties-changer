package dev.palestiner;

import picocli.CommandLine;

public class Main  {

    public static void main(String[] args) {
        int code = new CommandLine(new PcCommand()).execute(args);
        System.exit(code);
    }

    public static <E extends Throwable> void sneakyThrow(Throwable e) throws E {
        throw (E) e;
    }

}
