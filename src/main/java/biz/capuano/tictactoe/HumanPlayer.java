package biz.capuano.tictactoe;
import java.util.Scanner;

class HumanPlayer extends Player {

    public HumanPlayer(char mark) {
        super(mark);
    }

    @Override
    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        Move move;
        while(true) {
            String row, col;
            while (true) {
                System.out.print("Player " + mark + ", enter row (1-3) and column (1-3): ");
                row = scanner.next();
                col = scanner.next();
                if (("1".equals(row) || "2".equals(row) || "3".equals(row))
                        && ("1".equals(col) || "2".equals(col) || "3".equals(col)))
                    break;
                System.out.println("Invalid input!");
            }            
            move = new Move(Integer.parseInt(row), Integer.parseInt(col));
            if (board.makeMove(move, mark)) 
                break;    
            System.out.println("Illegal move!");
        }
        return move;
    }
}