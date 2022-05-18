public class Error {

    private Position pos_start;
    private Position pos_end;
    private String error_name;
    private String details;

    // constructor
    Error(Position pos_start,Position pos_end,String error_name,String details){
        this.pos_start = pos_start;
        this.pos_end = pos_end;
        this.error_name = error_name;
        this.details = details;
    }
    // method to evaluate string
    public String as_string(){
        String result;
        result = this.error_name + ":" + this.details + "\n";
        result += "File " + this.pos_start.getFn() + "," + "line " + this.pos_start.getLn() + 1;
        return result;
    }
}

