package OtherProjects.Lab03.garbage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GarbageCreator {
    public static void createGarbage() {
        try {
            File file = new File("longfile.txt");
            FileInputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            String result = "";
            while (inputStream.read(buffer) != -1) {
                result += new String(buffer);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
