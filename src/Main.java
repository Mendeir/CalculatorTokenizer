public class Main {
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

    public static void main(String[] args) {
        //test
        Token t = new Token();
        System.out.println(t.returnToken(TT_INT));
    }
}
