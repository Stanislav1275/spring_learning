package classes.Streaming;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Writer {
    public static void write(File file, String[] data) {
        try (PrintWriter writer = new PrintWriter(file)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str :data) {
                stringBuilder.append(str + "\n");
            }
            writer.write(stringBuilder.toString());
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


}
