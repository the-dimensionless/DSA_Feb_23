package java7.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOutputStreamEx {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/MyFile2.txt");
        String s = "Hi Again!";
        fos.write(s.getBytes(StandardCharsets.UTF_8));
        System.out.println("File" + fos.getFD());
        fos.close();
        System.out.println("Done");

    }
}
