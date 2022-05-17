import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("basic > ");
            String userText = scan.nextLine();
            ArrayList<String> tokenList = new ArrayList<String>();
            IllegalCharError error = run("<stdin>", userText, tokenList);

            System.out.println(error);
            if (userText.equals("exit"))
                break;

            if (error != null) {
                System.out.println(error.as_string());
            } else {
                System.out.println(tokenList);
            }
        }
    }

    private static IllegalCharError run(String fileDescriptor, String userText, ArrayList<String> givenTokenList) {
        Lexer lexer = new Lexer(fileDescriptor, userText);
        ArrayList<String> tokens = lexer.makeTokens();
        IllegalCharError error = lexer.getCharError();
        return error;
    }
}
