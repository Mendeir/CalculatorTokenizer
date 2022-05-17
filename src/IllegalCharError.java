public class IllegalCharError extends Error{
    // inherit the variables and methods of the Error class
    IllegalCharError(int pos_start, int pos_end, String error_name, String details) {
        super(pos_start, pos_end, error_name, details);
    }
}
