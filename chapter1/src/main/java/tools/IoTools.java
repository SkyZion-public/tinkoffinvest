package tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IoTools {

    public static void checkDirectoryExists (Path path) throws IOException {
        if (!(Files.exists(path) && Files.isDirectory(path)))
            throw new IOException(String.format("Directory %s does not exist", path.toString()));
    }

    public static void createDirectoryIfNotExists (Path path) throws IOException {
        try {
            checkDirectoryExists(path);
        } catch (IOException e) {
            Files.createDirectory(path);
        }
    }

}
