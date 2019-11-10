package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PieceTest {

    private Piece piece;

    public PieceTest() {
        piece = new Piece(Color.WHITE);
    }

    private Error advance(Coordinate[][] coordinates){
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = piece.move(coordinates[i][0], coordinates[i][1]);
        }
        return error;
    }
    
    @Test
    public void testGivenPieceWhenIsAdvancedThenTrue(){
        assertTrue(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(4,1)));
        assertTrue(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(3,2)));
    }

    @Test
    public void testGivenPieceWhenNotIsAdvancedThenFalse(){
        assertFalse(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(6,1)));
        assertFalse(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(5,2)));
        assertFalse(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(2,3)));
        assertFalse(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(1,2)));
    }

    @Test
    public void testGivenPieceWhenMoveBadDistanceThenError() {
        assertEquals(Error.BAD_DISTANCE, this.advance(new Coordinate[][] { 
            { new Coordinate(5, 0), new Coordinate(2, 3) },
        })); 
    }
}