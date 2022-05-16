public class Lexer {
    private String fileDescriptor;
    private String text;
    private Position position;
    private String current_char;

    public Lexer(String fileDescriptor, String text, Position position, String current_char) {
        this.fileDescriptor = fileDescriptor;
        this.text = text;
        this.position = position;
        this.current_char = current_char;
    }

    public Token makeNumber() {
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
                return Token(TT_INT, int(number_string));
            } else {
                return Token(TT_FLOAT, float(number_string));
            }
        }
    }
}
