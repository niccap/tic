package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board board;
    SimIO simIO = new SimIO();
    
    public BoardTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValidMove method, of class Board.
     */
    @Test
    public void testIsValidMove1() {
        System.out.println("Testing isValidMove: correct row and column");
        assertEquals(true, board.isValidMove(new Move(1,3)));
    }
    @Test
    public void testIsValidMove2() {
        System.out.println("Testing isValidMove: correct row wrong column");
        assertEquals(false, board.isValidMove(new Move(2,0)));
    }
    @Test
    public void testIsValidMove3() {
        System.out.println("Testing isValidMove: wrong row, correct column");
        assertEquals(false, board.isValidMove(new Move(4,2)));
    }
    @Test
    public void testIsValidMove4() {
        System.out.println("Testing isValidMove: wrong row and column");
        assertEquals(false, board.isValidMove(new Move(0,4)));
    }
    
    /**
     * Test of makeMove method, of class Board.
    */
    @Test
    public void testMakeMove1() {
        System.out.println("Testing makeMove: correct row and column");
        assertEquals(true, board.makeMove(new Move(2,2), 'X'));
    }
    @Test
    public void testMakeMove2() {
        System.out.println("Testing makeMove: correct row, wrong column");
        assertEquals(false, board.makeMove(new Move(2,-1), 'O'));
    }
    @Test
    public void testMakeMove3() {
        System.out.println("Testing makeMove: wrong row, correct column");
        assertEquals(false, board.makeMove(new Move(4,1), 'X'));
    }
    @Test
    public void testMakeMove4() {
        System.out.println("Testing makeMove: wrong row and column");
        assertEquals(false, board.makeMove(new Move(-2,-2), 'O'));
    }
    @Test   
    public void testMakeMove5() {
        System.out.println("Testing makeMove: occupied cell, same symbol");
        assertEquals(true, board.makeMove(new Move(1,3), 'X'));
        assertEquals(false, board.makeMove(new Move(1,3), 'X'));
    }
    @Test   
    public void testMakeMove6() {
        System.out.println("Testing makeMove: occupied cell, different symbol");
        assertEquals(true, board.makeMove(new Move(3,1), 'X'));
        assertEquals(false, board.makeMove(new Move(3,1), 'O'));
    }
    
    /**
     * Test of isFull method, of class Board.
    */
    @Test
    public void testIsFull1() {
        System.out.println("Testing isFull: empty board");
        assertEquals(false, board.isFull());
    }
    @Test
    public void testIsFull2() {
        System.out.println("Testing isFull: not full");
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'O');
        board.makeMove(new Move(1,3), 'X');
        board.makeMove(new Move(2,1), 'O');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(2,3), 'O');
        assertEquals(false, board.isFull());
    }
    @Test
    public void testIsFull3() {
        System.out.println("Testing isFull: almost full");
        board.makeMove(new Move(1,1), 'O');
        board.makeMove(new Move(1,2), 'X');
        board.makeMove(new Move(1,3), 'O');
        board.makeMove(new Move(2,1), 'X');
        board.makeMove(new Move(2,2), 'O');
        board.makeMove(new Move(2,3), 'X');
        board.makeMove(new Move(3,1), 'O');
        board.makeMove(new Move(3,2), 'X');
        assertEquals(false, board.isFull());        
    }
    @Test
    public void testIsFull4() {
        System.out.println("Testing isFull: full");
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'O');
        board.makeMove(new Move(1,3), 'X');
        board.makeMove(new Move(2,1), 'O');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(2,3), 'O');
        board.makeMove(new Move(3,1), 'X');
        board.makeMove(new Move(3,2), 'O');
        board.makeMove(new Move(3,3), 'X');
        assertEquals(true, board.isFull());        
    }

    /**
     * Test of checkForWin method, of class Board.
    */
    @Test
    public void testCheckForWin1() {
        System.out.println("Testing checkForWin: empty board");
        assertEquals(false, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));

    }
    @Test
    public void testCheckForWin2() {
        System.out.println("Testing checkForWin: horizontal win");
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'X');
        board.makeMove(new Move(1,3), 'X');
        assertEquals(true, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));

    }
    @Test
    public void testCheckForWin3() {
        System.out.println("Testing checkForWin: vertical win");
        board.makeMove(new Move(1,2), 'O');
        board.makeMove(new Move(2,2), 'O');
        board.makeMove(new Move(3,2), 'O');        
        assertEquals(false, board.checkForWin('X'));
        assertEquals(true, board.checkForWin('O'));
    }
    @Test
    public void testCheckForWin4() {
        System.out.println("Testing checkForWin: diagonal win");
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(3,3), 'X');
        assertEquals(true, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));
    }
    @Test
    public void testCheckForWin5() {
        System.out.println("Testing checkForWin: no win");
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'O');
        board.makeMove(new Move(1,3), 'X');
        board.makeMove(new Move(2,1), 'O');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(2,3), 'O');
        assertEquals(false, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));
    }
    @Test
    public void testCheckForWin6() {
        System.out.println("Testing checkForWin: full board, no win");
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(1,2), 'O');
        board.makeMove(new Move(1,3), 'X');
        board.makeMove(new Move(2,1), 'O');
        board.makeMove(new Move(2,2), 'X');
        board.makeMove(new Move(2,3), 'O');
        board.makeMove(new Move(3,1), 'O');
        board.makeMove(new Move(3,2), 'X');
        board.makeMove(new Move(3,3), 'O');
        assertEquals(false, board.checkForWin('X'));
        assertEquals(false, board.checkForWin('O'));
    }
    
    /**
     * Test of print method, of class Board.
    */
    @Test
    public void testPrint1() {
        System.out.println("Testing print: empty board");
        simIO.captureOutput();
        board.print();
        String expectedOutput = "┌───┬───┬───┐\n│   │   │   │ \n├───┼───┼───┤\n│   │   │   │ \n├───┼───┼───┤\n│   │   │   │ \n└───┴───┴───┘";
        assertEquals(expectedOutput, simIO.getCapturedOutput().trim());
        simIO.restoreOutput();
    }
    @Test
    public void testPrint2() {
        System.out.println("Testing print: non-empty board");
        simIO.captureOutput();
        board.makeMove(new Move(1,1), 'X');
        board.makeMove(new Move(2,2), 'O');
        board.print();
        String expectedOutput = "┌───┬───┬───┐\n│ X │   │   │ \n├───┼───┼───┤\n│   │ O │   │ \n├───┼───┼───┤\n│   │   │   │ \n└───┴───┴───┘";
        assertEquals(expectedOutput, simIO.getCapturedOutput().trim());
        simIO.restoreOutput();
    }
}
