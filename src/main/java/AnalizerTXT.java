
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by Sus on 18.09.2017.
 */
public class AnalizerTXT {

    public String cleanText(String text) {
        text = text.toLowerCase().trim();
        ReaderTXT readerTXT = new ReaderTXT();
        readerTXT.setPATH(String.valueOf(this.getClass().getResource("Exeptions.txt")));

        String[] badWords = readerTXT.readFromFile().trim().split("\r\n");
        String[] simbols = {". ", ".\r\n", "\r\n", ", ", "! ", "? ", ";", ":", "'",
                "&", "*", "-", "_", "+", "=", "\\", "|", "/", "\n", "\r"};

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
        Map<String, Integer> topTable = new TreeMap<String, Integer>();
        for (String i : wordsFromText) {
            if (topTable.containsKey(i)) {
                topTable.put(i, (topTable.get(i) + 1));
            } else {
                topTable.put(i, 1);
            }
        }
        printTop10(topTable);
    }


    public void printTop10(Map map) {
        TreeSet valueSet = new TreeSet(map.values());
        ArrayList valueList = new ArrayList(valueSet);
        Map<String, Integer> resultTable = new HashMap<String, Integer>();
        Collection<String> collection = map.keySet();

        for (int i = valueList.size() - 1; i >= 0; i--) {
            for (String j : collection) {
                if (resultTable.size() < 10) {
                    if (parseInt(map.get(j).toString()) == parseInt(valueList.get(i).toString())) {
                        resultTable.put(j, parseInt(map.get(j).toString()));
                        System.out.println("Word: " + j + " Used: "
                                + resultTable.get(j));
                    }
                } else {
                    break;
                }
            }
        }
    }


}
