package biz.capuano.tictactoe;

abstract class Player {
    protected final char mark;
    
    protected Player(char mark) {
        this.mark = mark;
    }
    
    public char getMark() {
        return mark;
    }

    public abstract Move makeMove(Board board);
}