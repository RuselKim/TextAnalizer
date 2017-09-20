/**
 * Created by Sus on 17.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        String text;
        String cleanedText;
        AnalizerTXT analizerTXT = new AnalizerTXT();
        BracketAnalizer bracketAnalizer = new BracketAnalizer();
        ReaderTXT readerTXT = new ReaderTXT();

        readerTXT.setPATH("d:\\test.txt");

        text = readerTXT.readFromFile();
        cleanedText = analizerTXT.cleanText(text);
        analizerTXT.analyzeTXT(cleanedText);
        System.out.println("Brackets are placed " +  bracketAnalizer.analizeBracket(text));


    }
}
