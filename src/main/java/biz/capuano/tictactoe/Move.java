package biz.capuano.tictactoe;

class Move {
    private final int row;
    private final int col;
    private int x;

    public Move(int row, int col) {
        this.row = row;
        this.col = col;
        this.x = 0;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
