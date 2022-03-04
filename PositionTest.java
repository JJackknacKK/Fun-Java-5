//CSDS 132 YINGYU ZHU

package chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void testPosition() {
        Position position1 = new Position(4, 4);
        Position position2 = new Position(position1);
        assertEquals(position1, position2);
    }

    @Test
    public void getCol() {
        Position position = new Position(2, 4);
        assertEquals(4, position.getCol());
    }

    @Test
    public void setCol() {
        Position position = new Position(1, 2);
        position.setCol(3);
        assertEquals(3, position.getCol());
    }

    @Test
    public void getRow() {
        Position position = new Position(1, 2);
        assertEquals(1, position.getRow());
    }

    @Test
    public void setRow() {
        Position position = new Position(1, 2);
        position.setRow(3);
        assertEquals(3, position.getRow());
    }

    @Test
    public void getNorthPosition() {
        Position position = new Position(3, 4);
        Position position1 = position.getNorthPosition();
        assertEquals(2, position1.getRow());
    }

    @Test
    public void testGetNorthPosition() {
        Position position = new Position(3, 4);
        Position position1 = position.getNorthPosition(2);
        assertEquals(1, position1.getRow());
    }

    @Test
    public void getSouthPosition() {
        Position position = new Position(3, 4);
        Position position1 = position.getSouthPosition();
        assertEquals(4, position1.getRow());
    }

    @Test
    public void testGetSouthPosition() {
        Position position = new Position(3, 4);
        Position position1 = position.getSouthPosition(2);
        assertEquals(5, position1.getRow());
    }

    @Test
    public void getWestPosition() {
        Position position = new Position(3, 4);
        Position position1 = position.getWestPosition();
        assertEquals(3, position1.getCol());
    }

    @Test
    public void testGetWestPosition() {
        Position position = new Position(3, 4);
        Position position1 = position.getWestPosition(2);
        assertEquals(2, position1.getCol());
    }

    @Test
    public void getEastPosition() {
        Position position = new Position(3, 4);
        Position position1 = position.getEastPosition();
        assertEquals(5, position1.getCol());
    }

    @Test
    public void testGetEastPosition() {
        Position position = new Position(3, 4);
        Position position1 = position.getEastPosition(2);
        assertEquals(6, position1.getCol());
    }

    @Test
    public void testEquals() {
        assertEquals(new Position(5, 6), new Position(5, 6));
        assertEquals(new Position(5, 6), new Position(new Position(5, 6)));
    }

    @Test
    public void onSameRow() {
        assertTrue(new Position(5, 6).onSameRow(new Position(5, 4)));
        assertFalse(new Position(5, 6).onSameRow(new Position(6, 5)));
    }

    @Test
    public void onSameCol() {
        assertTrue(new Position(5, 6).onSameCol(new Position(4, 6)));
        assertFalse(new Position(5, 6).onSameCol(new Position(6, 5)));
    }

    @Test
    public void isAround() {
        assertFalse(new Position(1, 2).isAround(new Position(1, 2)));
        assertTrue(new Position(1, 2).isAround(new Position(2, 1)));
        assertFalse(new Position(1, 2).isAround(new Position(1, 5)));
    }
}