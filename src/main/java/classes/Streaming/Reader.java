package classes.Streaming;

import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader implements Readable {
    @Override
    public String[] read(File file) {
        List<String> data = new ArrayList<>();

        try (Scanner scanner = new Scanner(file).useDelimiter("\\n")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data.add(line);
            }
            return data.toArray(String[]::new);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
