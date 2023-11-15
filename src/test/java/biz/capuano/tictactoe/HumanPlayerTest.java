package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {
    
    private HumanPlayer player;
    private Board board;
    SimIO simIO = new SimIO();

    public HumanPlayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        player = new HumanPlayer('O');
        board = new Board();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getMark method, of class HumanPlayer.
     */
    @Test
    public void testGetMark() {
        System.out.println("Testing getMark");
        assertEquals('O', player.getMark());
    }

    /**
     * Test of makeMove method, of class HumanPlayer.
     */
        
    @Test
    public void testMakeMove1() {
        System.out.println("Tesing MakeMove: valid move");

        simIO.simulateInput("2 3\n");
        Move move = player.makeMove(board);
        assertEquals(2, move.getRow());
        assertEquals(3, move.getCol());
        simIO.restoreInput();
    }    
    @Test
    public void testMakeMove2() {
        System.out.println("Tesing MakeMove: invalid move");
        
        simIO.simulateInput("1 4 2 3\n");
        Move move = player.makeMove(board);
        assertEquals(2, move.getRow());
        assertEquals(3, move.getCol());
        simIO.restoreInput();
    }    
    @Test
    public void testMakeMove3() {
        System.out.println("Tesing MakeMove: occupied cell");
        
        simIO.simulateInput("2 3\n");
        player.makeMove(board);
        simIO.simulateInput("2 3 3 3\n");
        Move move = player.makeMove(board);
        assertEquals(3, move.getRow());
        assertEquals(3, move.getCol());
        simIO.restoreInput();
    }    
}
