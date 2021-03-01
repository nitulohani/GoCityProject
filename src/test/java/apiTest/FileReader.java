package apiTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public static String readFile(String fileName) {
        try {
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            return Files.readString(Paths.get(loader.getResource(fileName).toURI()));

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Process failed while reading file", e);
        }
    }
}