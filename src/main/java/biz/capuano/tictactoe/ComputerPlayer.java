package biz.capuano.tictactoe;
import java.util.Random;

class ComputerPlayer extends Player {
    private static final Random random = new Random();

    public ComputerPlayer(char mark) {
        super(mark);
    }

    @Override
    public Move makeMove(Board board) {
        Move move;
        do {
            move = new Move(random.nextInt(Board.SIZE) + 1, random.nextInt(Board.SIZE) + 1);
        } while (!board.makeMove(move, mark));
        System.out.println("Computer player " + mark + ", moves in row " + move.getRow() + ", column " + move.getCol());
        return move;
    }
}

