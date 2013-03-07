package test.stratego.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stratego.common.StrategoException;
import stratego.model.StrategoBoard;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

public class TestStrategoBoard {
	StrategoBoard board;
	@Before //Will run before every single test
	public void setup(){
		board = new StrategoBoard();
	}
	@Test
	public void testConstructor(){
		assertEquals(0 , board.GetBoard()[0][0].getX()); //Checks to make sure index 0,0 is at 0,0
		assertEquals(0 , board.GetBoard()[0][0].getY());
		assertTrue(board.GetBoard()[0][0].isPlaceable()); //check boolean (example)
	}
	@Test
	public void unplaceableLocationsProperlySet(){
		assertEquals(false , board.GetBoard()[2][5].isPlaceable()); //check to make sure is placeable
		
	}
	@Test(expected = StrategoException.class) //this should be true
	public void throwExceptionToPlaceAtUnplaceableLocation() throws StrategoException{
		//Populate 2, 5
		board.GetBoard()[2][5].Populate(StrategoPlayerColor.RED, StrategoPieceType.FLAG);
		fail("Exception Expected"); //Fails test if no exception thrown
	}
	@Test(expected = StrategoException.class)
	public void placeNullValueAtValidLocation() throws StrategoException{
		board.GetBoard()[1][3].Populate(null, StrategoPieceType.FLAG);
		fail("Exception Expected"); 
 
	}
}
