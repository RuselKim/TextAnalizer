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

        //get path to file from User.

        System.out.println("Please enter  path to the file \r\n");
        try {
            path = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readerTXT.setPATH(path);

        //now read text from file, and save it into String.
        text = readerTXT.readFromFile();

        //delete from text all punctuation marks and unnecessary words.
        cleanedText = analizerTXT.cleanText(text);

        //analyze text and count the words.
        analizerTXT.analyzeTXT(cleanedText);

        //check brackets;
        System.out.println("Brackets are placed " +  bracketAnalizer.analizeBracket(text));
    }
}
