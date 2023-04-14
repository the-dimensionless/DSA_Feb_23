package java7.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInputStreamEx {


    public static void main(String[] args) throws IOException {
        String defaultDirectory = System.getProperty("user.dir");
        System.out.println("Current dir => " + defaultDirectory);

        FileInputStream fis = null;
        fis = new FileInputStream("/MyFile.txt");
        int i = 0;
        while ((i = fis.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();
        fis.close();


        Path path = Path.of("");
        System.out.println("Default path is " + path.toString());

        System.out.println("Absolute path is " + path.toAbsolutePath().toString());


    }
}
