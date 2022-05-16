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
}
