/**
 * Created by Sus on 17.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        String text;
        ReaderTXT readerTXT = new ReaderTXT();
        readerTXT.setPATH("d:\\test.txt");
        text = readerTXT.readFromFile();
        System.out.println(text);

    }
}
