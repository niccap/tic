package biz.capuano.tictactoe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    
    public MoveTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRow method, of class Move.
     */
    @Test
    public void testGetRow() {
        System.out.println("Testing getRow");
        Move move = new Move(1, 2);
        assertEquals(1, move.getRow());
    }

    /**
     * Test of getCol method, of class Move.
     */
    @Test
    public void testGetCol() {
        System.out.println("Testing getCol");
        Move move = new Move(1, 2);
        assertEquals(2, move.getCol());
    }
    
}
