package OtherProjects.hust.soict.dsai.lab03.garbage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {
    public static void readLongFile() {
        try {
            File file = new File("longfile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            String result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
