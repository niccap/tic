package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {
    
    ComputerPlayer player;

    public ComputerPlayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        player = new ComputerPlayer('X');
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getMark method, of class ComputerPlayer.
     */
    @Test
    public void testGetMark() {
        System.out.println("Testing getMark");
        assertEquals('X', player.getMark());
    }

    /**
     * Test of makeMove method, of class ComputerPlayer.
     */
    @Test
    public void testMakeMove1() {
        System.out.println("Testing makeMove: verify move validity");
        Board board = new Board();
        for (int i = 0; i < 9; ++i) {
            Move move = player.makeMove(board);
            assertTrue(move.getRow() >= 1 && move.getRow() <= 3);
            assertTrue(move.getCol() >= 1 && move.getCol() <= 3);
        }
    }
    @Test
    public void testMakeMove2() {
        System.out.println("Testing makeMove: verify non-repetition");
        Board board = new Board();
        Move move = player.makeMove(board);
        for (int i = 0; i < 8; ++i) {
            Move newMove = player.makeMove(board);
            assertFalse(newMove.getRow() == move.getRow() && newMove.getCol() == move.getCol());
        }
    }
    
}
