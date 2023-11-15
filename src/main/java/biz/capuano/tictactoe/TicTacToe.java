package biz.capuano.tictactoe;
import java.util.Scanner;

public class TicTacToe {

    private static final Scanner scanner = new Scanner(System.in);

    private static Player generatePlayer(char mark) {
        while (true) {
            System.out.print("Player " + mark + " (H)uman or (C)omputer? ");
            String s = scanner.next();
            if ("H".equals(s.toUpperCase()))
                return new HumanPlayer(mark);
            else if ("C".equals(s.toUpperCase()))
                return new ComputerPlayer(mark);
            System.out.println("Invalid input!");
        }
    }

    private static void startNewGame() {
        Game game;
        Player playerX = generatePlayer('X');
        Player playerO = generatePlayer('O');
        game = new Game(playerX, playerO);
        game.play();
    }

    private static boolean playAgain() {
        while (true) {
            System.out.print("Play again (Y/N)? ");
            String s = scanner.next();
            if ("Y".equals(s.toUpperCase()))
                return true;
            else if ("N".equals(s.toUpperCase()))
                return false;
            System.out.println("Invalid input!");
        }
    }

    public static void main(String[] args) {
        do startNewGame(); 
        while (playAgain());
        System.out.println("Good bye!");
    }
}
