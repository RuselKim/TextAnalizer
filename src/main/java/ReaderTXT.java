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
            while ((line = bufferedReader.readLine()) != null) {           //read text from file and create a String
                text += System.getProperty("line.separator") + line;        //i'm using line.separator because i don't know
            }                                                               //witch OS is using;
        } catch (FileNotFoundException e) {
            System.out.println("File is not found. Please try again");    //if there were no file with such path, ask to enter path again.
            Main.getPathFromUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
