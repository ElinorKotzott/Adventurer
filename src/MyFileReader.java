import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MyFileReader {
    public static ArrayList<String> loadBossNames () {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("C:/Users/Uporabnik/IdeaProjects/JavaCourse/src/Resources/namesOfBosses.txt"));
            ArrayList <String> bossNames = new ArrayList<>();
            String line = br.readLine();

            while (line != null) {
                bossNames.add(line);
                line = br.readLine();
            }
            return bossNames;
        } catch (Exception e) {
            System.out.println("An exception was thrown. The file could not be read");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception f) {
                System.out.println("A problem has occurred");
            }
        }
        return null;
    }
}
