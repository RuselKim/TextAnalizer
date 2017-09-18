
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sus on 18.09.2017.
 */
public class AnalizerTXT {

    public String cleanText(String text) {
        text = text.toLowerCase().trim();
        ReaderTXT readerTXT = new ReaderTXT();
        readerTXT.setPATH("d:\\Exeptions.txt");

        String[] badWords = readerTXT.readFromFile().trim().split("\r\n");
        String[] simbols = {".", ",", "!", "?", ";", ":", "'", "&", "*", "-", "_", "+", "=", "\\", "|", "/"};

        for (int i = 0; i < simbols.length; i++) {
            text = text.replace(simbols[i], " ");
        }

        for (int i = 0; i < badWords.length; i++) {
            text = text.replace(badWords[i], " ");
        }
        return text;
    }


    public void analyzeTXT(String text) {
        String[] wordsFromText = text.split(" ");
        Map<String, Integer> topTable = new HashMap<String, Integer>();
        for (String i : wordsFromText) {
            if (topTable.containsKey(i)) {
                topTable.put(i, (topTable.get(i) + 1));
            } else {
                topTable.put(i, 1);
            }
        }
        for (Map.Entry entry : topTable.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }


}
