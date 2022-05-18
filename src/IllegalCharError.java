public class IllegalCharError extends Error{
    // inherit the variables and methods of the Error class
    IllegalCharError(Position pos_start, Position pos_end, String details) {
        super(pos_start, pos_end, "Illegal Character", details);
    }
}
