import sun.nio.cs.StandardCharsets;

import java.io.*;

/**
 * Created by Sus on 17.09.2017.
 */
public class ReaderTXT {
    private String Path;


    public void setPATH(String Path) {
        this.Path = Path;
    }


    protected String readFromFile() {

        String text = "";
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Path)));
            while ((line = bufferedReader.readLine()) != null) {
                text += System.getProperty("line.separator") + line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
