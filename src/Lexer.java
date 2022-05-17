import java.util.Dictionary;
import java.util.Hashtable;

public class Lexer {
    private String fileDescriptor;
    private String text;
    private Position position;
    private String current_char;
    private Token token;
    private Dictionary tokens;

    public Lexer(String fileDescriptor, String text, Position position, String current_char) {
        this.fileDescriptor = fileDescriptor;
        this.text = text;
        this.position = position;
        this.current_char = current_char;
        this.token = new Token();
        this.tokens = new Hashtable();
    }

    public void makeNumber() {
        String number_string = " ";
        int dot_count = 0;

        while (current_char != " ") {
            if (current_char == ".") {
                if (dot_count == 1)
                    break;
                dot_count += 1;
                number_string += ".";
            } else {
                number_string += current_char;
            }

            if (dot_count == 0) {
                //return token.returnToken()
                return;
            } else {
                //return Token(TT_FLOAT, float(number_string));
                return;
            }
        }
    }
}