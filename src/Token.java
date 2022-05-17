public class Token{
    //User defined constants for passing value to tokens
    //came from gdrive reference
    protected static String TT_INT = "INT";
    protected static String TT_FLOAT = "FLOAT";
    protected static String TT_PLUS = "PLUS";
    protected static String TT_MINUS = "MINUS";
    protected static String TT_MUL = "MUL";
    protected static String TT_DIV = "DIV";
    protected static String TT_LPAREN = "LPAREN";
    protected static String TT_RPAREN = "RPAREN";

    static String returnToken(String type, String value){

        return String.format("%1$s:%2$s", type, value);
    }
    
    static String returnToken(String type, int value){

        return String.format("%1$s:%2$d", type, value);
    }

    static String returnToken(String type, float value){

        return String.format("%1$s:%2$.2f", type, value);
    }
    static String returnToken(String type){
        return type;
    }

}