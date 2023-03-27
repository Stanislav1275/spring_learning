package classes.Streaming;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;

public interface Readable {
    String[] read(File file);
}
