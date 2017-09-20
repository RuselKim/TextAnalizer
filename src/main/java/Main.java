import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sus on 17.09.2017.
 */
public class Main {

    static String text;
    static String cleanedText;
    static AnalizerTXT analizerTXT = new AnalizerTXT();
    static BracketAnalizer bracketAnalizer = new BracketAnalizer();
    static ReaderTXT readerTXT = new ReaderTXT();

    public static void main(String[] args) {

        getPathFromUser();

    }

    public static void getPathFromUser(){
        String path = "";
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter  path to the file \r\n");
        try {
            path = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readerTXT.setPATH(path);
        text = readerTXT.readFromFile();
        cleanedText = analizerTXT.cleanText(text);
        analizerTXT.analyzeTXT(cleanedText);
        System.out.println("Brackets are placed " +  bracketAnalizer.analizeBracket(text));
    }
}
