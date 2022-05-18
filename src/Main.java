import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> tokenList = new ArrayList<String>();

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("basic > ");
            String userText = scan.nextLine();

            if (userText.equals("exit"))
                break;
            userText += "\n";

            IllegalCharError error = run("<stdin>", userText);

            if (error != null) {
                System.out.println(error.as_string());
            } else {
                System.out.println(tokenList);
            }
        }
    }

    private static IllegalCharError run(String fileDescriptor, String userText) {
        Lexer lexer = new Lexer(fileDescriptor, userText);
        tokenList = lexer.makeTokens();
        IllegalCharError error = lexer.getCharError();
        return error;
    }
}
