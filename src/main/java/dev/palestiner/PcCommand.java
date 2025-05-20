package dev.palestiner;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Callable;

import static dev.palestiner.Main.sneakyThrow;
import static dev.palestiner.PropertyLoader.fromFile;

@Command(name = "pc")
public class PcCommand implements Callable<Integer> {

    @Option(names = {"-k", "--key"}, defaultValue = "key", required = true)
    private String key;

    @Option(names = {"-v", "--value", "--val"}, defaultValue = "value", required = true)
    private String value;

    @Option(
            names = {"-f", "--property-file-path", "--props"},
            defaultValue = "application.properties",
            required = true
    )
    private String propertyFileName;

    @Override
    public Integer call() {
        Properties properties = fromFile(propertyFileName);
        try (FileOutputStream out = new FileOutputStream(propertyFileName)) {
            properties.setProperty(key, value);
            properties.store(out, null);
        } catch (IOException e) {
            sneakyThrow(e);
        }
        return 0;
    }
}
