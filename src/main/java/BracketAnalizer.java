/**
 * Created by Sus on 20.09.2017.
 */
public class BracketAnalizer {

    public String analizeBracket(String text) {

        StringBuilder stringBuilder = new StringBuilder(text);
        String bracketString = "";

        for (int i = 0; i < stringBuilder.length(); i++) {          //take all brackets into one string.
            if ((stringBuilder.charAt(i) == '(') || (stringBuilder.charAt(i) == '{')
                    || (stringBuilder.charAt(i) == '[') || (stringBuilder.charAt(i) == ')')
                    || stringBuilder.charAt(i) == '}' || (stringBuilder.charAt(i) == ']')) {
                bracketString += stringBuilder.charAt(i);
            }
        }

        stringBuilder = new StringBuilder(bracketString);           //If the opened bracket is closed, delete pair;
        for (int i = 0; i < stringBuilder.length() - 1; i++) {
            if ((stringBuilder.charAt(i) == '(') && (stringBuilder.charAt(i + 1) == ')')
                    || (stringBuilder.charAt(i) == '[') && (stringBuilder.charAt(i + 1) == ']')
                    || (stringBuilder.charAt(i) == '{') && (stringBuilder.charAt(i + 1) == '}')) {
                stringBuilder.delete(i, 1);
                stringBuilder.delete(i, 1);
                i = -1;
            }
        }
        if (bracketString.length() == 0) {          //if there is no bracket left, than brackets are placed correctly;
            return ("correctly");
        } else {
            return ("incorrectly");
        }
    }
}






