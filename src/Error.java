public class Error {

    private int pos_start;
    private int pos_end;
    private String error_name;
    private String details;

    // constructor
    Error(int pos_start,int pos_end,String error_name,String details){
        this.pos_start = pos_start;
        this.pos_end = pos_end;
        this.error_name = error_name;
        this.details = details;
    }
    // method to evaluate string
    public String as_string(){
        String result;
        result = this.error_name + ":" + this.details;
        return result;
    }
}

