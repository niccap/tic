package biz.capuano.tictactoe;

class Game {
    private final Player player1;
    private final Player player2;
    private final Board board;
    private Player currentPlayer;
    
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayer = player1;
    }

    public void play() {
        while (true) {
            board.print();
            currentPlayer.makeMove(board);

            if (board.checkForWin(currentPlayer.getMark())) {
                board.print();
                System.out.println("Player " + currentPlayer.getMark() + " wins!");
                break;
            } else if (board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
                break;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }
}