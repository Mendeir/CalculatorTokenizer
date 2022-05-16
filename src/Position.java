public class Position {
    private int idx, ln, col, fn;
    private String ftxt;

    public Position(int idx, int ln, int col, int fn, String ftxt){
        this.idx = idx;
        this.ln = ln;
        this.col = col;
        this.fn = fn;
        this.ftxt = ftxt;
    }
    
    Position advance(char current_char){
        this.idx += 1;
        this.col += 1;
        
        if(current_char == '\n'){
            this.ln += 1;
            this.col = 0;
        }
        
        return this;   
    }
}
