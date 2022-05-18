public class Token{
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