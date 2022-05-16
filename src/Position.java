public class Position {
    private int idx, ln, col;
    private String fn, ftxt;

    public Position(int idx, int ln, int col, String fn, String ftxt){
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

    Position copy(){
        return new Position(this.idx, this.ln, this.col, this.fn, this.ftxt);
    }
}
