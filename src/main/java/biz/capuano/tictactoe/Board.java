package biz.capuano.tictactoe;

class Board {
    public static final int SIZE = 3;
    private final char[][] cells;
    public String x, y;

    public Board() {
        cells = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                cells[i][j] = ' ';
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            System.out.print("│ ");
            for (int j = 0; j < 3; j++)
                System.out.print(cells[i][j] + " │ ");
            if (i < 2)
                System.out.println("\n├───┼───┼───┤");
            else
                System.out.println("\n└───┴───┴───┘\n");
        }
    }

    public boolean isValidMove(Move move) {
        return (move.getRow() >= 1 && move.getRow() <= SIZE && move.getCol() >= 1 
                && move.getCol() <= SIZE && cells[move.getRow() - 1][move.getCol() - 1] == ' ');    
    }

    public boolean makeMove(Move move, char mark) {
        if (!isValidMove(move))
            return false;
        cells[move.getRow() - 1][move.getCol() - 1] = mark;
        return true;    
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (cells[i][j] == ' ')
                    return false;
        return true;
    }

    public boolean checkForWin(char mark) {
        for (int i = 0; i < SIZE; i++) {
            if (cells[i][0] == mark && cells[i][1] == mark && cells[i][2] == mark)
                return true;
            if (cells[0][i] == mark && cells[1][i] == mark && cells[2][i] == mark)
                return true;
        }
        if (cells[0][0] == mark && cells[1][1] == mark && cells[2][2] == mark)
            return true;
        return cells[0][2] == mark && cells[1][1] == mark && cells[2][0] == mark;
    }
}

    