
import java.net.URISyntaxException;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by Sus on 18.09.2017.
 */
public class AnalizerTXT {

    public String cleanText(String text) {
        text = text.toLowerCase().trim();
        ReaderTXT readerTXT = new ReaderTXT();
        try {
            readerTXT.setPATH( Main.class.getResource("Exeptions.txt").toURI().getPath()); //read the words that
        } catch (URISyntaxException e) {                                            //need to be excluded from statistics from file
            e.printStackTrace();
        }


        String[] badWords = readerTXT.readFromFile().trim().split("\r\n");
        String[] simbols = {". ", ".\r\n", "\r\n", ", ", "! ", "? ", ";", ":", "'",
                "&", "*", "-", "_", "+", "=", "\\", "|", "/", "\n", "\r"};

        for (int i = 0; i < simbols.length; i++) {              //deleting from text all simbols
            text = text.replace(simbols[i], " ");
        }

        for (int i = 0; i < badWords.length; i++) {              //deleting from text all "bad words"
            text = text.replace(badWords[i], " ");
        }
        return text;
    }


    public void analyzeTXT(String text) {
        String[] wordsFromText = text.split(" ");                       //sorts through all the words and count them.
        Map<String, Integer> topTable = new TreeMap<String, Integer>();
        for (String i : wordsFromText) {
            if (topTable.containsKey(i)) {
                topTable.put(i, (topTable.get(i) + 1));
            } else {
                topTable.put(i, 1);
            }
        }
        printTop10(topTable); //get Top10 words and print them.
    }


    public void printTop10(Map map) {
        TreeSet valueSet = new TreeSet(map.values());       //used TreeSet to sort values;
        ArrayList valueList = new ArrayList(valueSet);      //convert to array list course it's more comfortable to get values;
        Map<String, Integer> resultTable = new HashMap<String, Integer>();  //create HashMap fo Top 10 words;
        Collection<String> collection = map.keySet();
                                                                    //compare values from list with values from map
        for (int i = valueList.size() - 1; i >= 0; i--) {           //and put the same into resultTable, from max to low.
            for (String j : collection) {
                if (resultTable.size() < 10) {
                    if (parseInt(map.get(j).toString()) == parseInt(valueList.get(i).toString())) {
                        resultTable.put(j, parseInt(map.get(j).toString()));
                        System.out.println("Word: " + j + " Used: "
                                + resultTable.get(j));
                    }
                } else {
                    break;                                          //stop when result table wil consist of 10 elements.
                }
            }
        }
    }


}
