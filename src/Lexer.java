import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import static java.lang.Character.isDigit;

public class Lexer {
    private String fileDescriptor;
    private String text;
    private Position position;
    private char current_char;
    private Token token;
    private Dictionary<String, String> tokens;
    private IllegalCharError charError;

    public Lexer(String fileDescriptor, String text) {
        this.fileDescriptor = fileDescriptor;
        this.text = text;
        this.position = new Position(-1,0,-1, fileDescriptor, text);
        this.token = new Token();
        this.tokens = new Hashtable<String, String>();
        this.Advance();
        fillUpDictionary();
    }

    public void Advance(){
        this.position.advance(this.current_char);
        if(this.position.getIdx() < text.length()){
            this.current_char = this.text.charAt(this.position.getIdx());
        }
    }

    public void fillUpDictionary() {
        tokens.put("TT_INT", "INT");
        tokens.put("TT_FLOAT", "FLOAT");
        tokens.put("TT_PLUS", "PLUS");
        tokens.put("TT_MINUS", "MINUS");
        tokens.put("TT_MUL", "MUL");
        tokens.put("TT_DIV", "DIV");
        tokens.put("TT_LPAREN", "LPAREN");
        tokens.put("TT_RPAREN", "RPAREN");

    }

    public ArrayList<String> makeTokens(){
        ArrayList<String> token = new ArrayList<String>(); // Create an ArrayList object
        while(current_char != '\n'){
            if (current_char == ' ' || current_char == '\t') {
                this.Advance();
            }else if(isDigit(current_char)){
                token.add(makeNumber());
            }else if(current_char == '+'){
                token.add(Token.TT_PLUS);
                this.Advance();
            }else if(current_char == '-'){
                token.add(Token.TT_MINUS);
                this.Advance();
            }else if(current_char == '*'){
                token.add(Token.TT_MUL);
                this.Advance();
            }else if(current_char == '/'){
                token.add(Token.TT_DIV);
                this.Advance();
            }else if(current_char == '('){
                token.add(Token.TT_LPAREN);
                this.Advance();
            }else if(current_char == ')'){
                token.add(Token.TT_RPAREN);
                this.Advance();
            }else{
                Position pos_start = this.position.copy();
                char characters = this.current_char;
                this.Advance();
                charError = new IllegalCharError(pos_start, this.position,"'" + characters + "'");
                return null;
                
            }
        }
        return token;
    }

    public String makeNumber() {
        StringBuilder number_string = new StringBuilder(" ");
        int dot_count = 0;

        while (current_char != '\n' && (isDigit(current_char) || current_char == '.')) {
            if (current_char == '.') {
                if (dot_count == 1)
                    break;
                dot_count += 1;
                number_string.append('.');
            } else {
                number_string.append(current_char);
            }
            this.Advance();
        }

        if (dot_count == 0) {
            return token.returnToken(tokens.get("TT_INT"), number_string.toString());
        } else {
            //return Token(TT_FLOAT, float(number_string));
            return token.returnToken(tokens.get("TT_FLOAT"), number_string.toString());
        }
    }

    public IllegalCharError getCharError() {
        return charError;
    }
}