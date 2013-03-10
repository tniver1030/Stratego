package test.stratego.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import stratego.common.StrategoException;
import stratego.model.StrategoBoard;
import stratego.model.StrategoBoardLocation;
import stratego.model.StrategoCoordImp;
import stratego.model.StrategoFactory;
import stratego.model.StrategoGameImp;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

public class TestStrategoGameImp {
	StrategoGameImp game;
	StrategoCoordImp c[][] = new StrategoCoordImp[10][10];

	//TODO Test moving on/through unplaceable locations
	
	@Before
	public void setupBoard() throws StrategoException{
		game = new StrategoGameImp();	
		for(int i = 0; i <= 9; i++){
			for(int j = 0; j < 9; j++){
				c[i][j] = new StrategoCoordImp(i, j);
			}
		}			
		game.makeMove(StrategoPieceType.BOMB, null, c[0][0], StrategoPlayerColor.RED);
		game.makeMove(StrategoPieceType.ONE, null, c[4][0], StrategoPlayerColor.RED);		
		game.makeMove(StrategoPieceType.EIGHT, null, c[1][0], StrategoPlayerColor.RED);
		game.makeMove(StrategoPieceType.ONE,null, c[2][0], StrategoPlayerColor.RED);
		game.makeMove(StrategoPieceType.TWO ,null, c[1][4], StrategoPlayerColor.RED);
		
	}
	@Test 
	public void testAllPiecesInPlace(){
		assertEquals(StrategoPieceType.BOMB , game.getBoard().GetBoard()[0][0].getPieceType());
		assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[4][0].getPieceType());
		assertEquals(StrategoPieceType.EIGHT , game.getBoard().GetBoard()[1][0].getPieceType());
		assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());
		assertEquals(StrategoPieceType.TWO , game.getBoard().GetBoard()[1][4].getPieceType());		
	}
	@Test(expected = StrategoException.class)
	public void testBombMovement() throws StrategoException{
		System.out.println("testBombMovement:");
		try{
		game.makeMove(StrategoPieceType.BOMB, c[0][0], c[0][1], null);
		}catch(StrategoException e){
			System.out.println(e.getMessage()); //Prints message to verify error
			throw e; //throws to prevent from failing
		}
	}
	@Test
	public void testRegularMovement1YSucceed() throws StrategoException{
		System.out.println("testRegularMovement1YSucceed:");
		try {
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());
			game.makeMove(StrategoPieceType.ONE, c[2][0], c[2][1], null);
			assertEquals(null , game.getBoard().GetBoard()[2][0].getPieceType());
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][1].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage()); //Prints message to verify error
			throw e;
		}	
	}
	@Test(expected = StrategoException.class)
	public void testRegularMovement1YFailMoveTooFar() throws StrategoException{
		System.out.println("testRegularMovement1YFailMoveTooFar");
		try {
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());
			game.makeMove(StrategoPieceType.ONE, c[2][0], c[2][2], null);
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());
			assertEquals(null , game.getBoard().GetBoard()[2][2].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage()); //Prints message to verify error
			throw e;
		}	
	}
	@Test(expected = StrategoException.class)
	public void testRegularMovement1YMoveOffBoard() throws StrategoException{
		System.out.println("testRegularMovement1YMoveOffBoard");
		try {
			StrategoCoordImp negCoord = new StrategoCoordImp(2, -1);
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());
			game.makeMove(StrategoPieceType.ONE, c[2][0], negCoord, null);
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());
			//assertEquals(null , game.getBoard().GetBoard()[2][-1].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage()); //Prints message to verify error
			throw e;
		}	
	}
	@Test(expected = StrategoException.class)
	public void testRegularMovement1YMoveIntoOtherPiece() throws StrategoException{
		System.out.println("testRegularMovement1YMoveIntoOtherPiece");
		try {
			game.makeMove(StrategoPieceType.BOMB, null, c[2][1], StrategoPlayerColor.RED); //add piece infront
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType()); //double check location
			assertEquals(StrategoPieceType.BOMB, game.getBoard().GetBoard()[2][1].getPieceType());			
			game.makeMove(StrategoPieceType.ONE, c[2][0], c[2][1], null);
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());//double check didnt move
			assertEquals(StrategoPieceType.BOMB , game.getBoard().GetBoard()[2][1].getPieceType());//double check didnt move
		} catch (StrategoException e) {
			System.out.println(e.getMessage()); //Prints message to verify error
			throw e;
		}	
	}
	@Test
	public void testRegularMovement1XSucceedNeg() throws StrategoException{
		System.out.println("testRegularMovement1XSucceedNeg:");
		try {
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[4][0].getPieceType());
			game.makeMove(StrategoPieceType.ONE, c[4][0], c[3][0], null);
			assertEquals(null , game.getBoard().GetBoard()[4][0].getPieceType());
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[3][0].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage()); //Prints message to verify error
			throw e;
		}	
	}
	@Test
	public void testRegularMovement1XSucceedPos() throws StrategoException{
		System.out.println("testRegularMovement1XSucceedPos:");
		try {
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[4][0].getPieceType());
			game.makeMove(StrategoPieceType.ONE, c[4][0], c[5][0], null);
			assertEquals(null , game.getBoard().GetBoard()[4][0].getPieceType());
			assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[5][0].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage()); //Prints message to verify error
			throw e;
		}	
	}
	@Test
	public void testScoutMoveYOneSucceedPos(){
		System.out.println("testScoutMoveYSucceedPos");
		assertEquals(StrategoPieceType.EIGHT, game.getBoard().GetBoard()[1][0].getPieceType());
		try {
			game.makeMove(StrategoPieceType.EIGHT, c[1][0], c[1][1], null);
			assertEquals(null, game.getBoard().GetBoard()[1][0].getPieceType());
			assertEquals(StrategoPieceType.EIGHT, game.getBoard().GetBoard()[1][1].getPieceType());
		} catch (StrategoException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testScoutMoveYThreeoSucceedPos() throws StrategoException{
		System.out.println("testScoutMoveYThreeSucceedPos");
		assertEquals(StrategoPieceType.EIGHT, game.getBoard().GetBoard()[1][0].getPieceType());
		try {
			game.makeMove(StrategoPieceType.EIGHT, c[1][0], c[1][3], null);
			assertEquals(StrategoPieceType.EIGHT, game.getBoard().GetBoard()[1][3].getPieceType());
			assertEquals(null, game.getBoard().GetBoard()[1][0].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	@Test(expected = StrategoException.class)
	public void testScoutMoveYFailAtEnemyPos() throws StrategoException{
		System.out.println("testScoutMoveYFailAtEnemyPos()");
		assertEquals(StrategoPieceType.EIGHT, game.getBoard().GetBoard()[1][0].getPieceType());
		try {
			game.makeMove(StrategoPieceType.EIGHT, c[1][0], c[1][4], null);
			assertEquals(StrategoPieceType.EIGHT, game.getBoard().GetBoard()[1][4].getPieceType());
			assertEquals(null, game.getBoard().GetBoard()[1][0].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	@Test(expected = StrategoException.class)
	public void testScoutMoveYFailPastEnemyPos() throws StrategoException{
		System.out.println("testScoutMoveYFailPastEnemyPos");
		assertEquals(StrategoPieceType.EIGHT, game.getBoard().GetBoard()[1][0].getPieceType());
		try {
			game.makeMove(StrategoPieceType.EIGHT, c[1][0], c[1][5], null);
			assertEquals(StrategoPieceType.EIGHT, game.getBoard().GetBoard()[1][5].getPieceType());
			assertEquals(null, game.getBoard().GetBoard()[1][0].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	@Test(expected = StrategoException.class)
	public void testFlagMovement() throws StrategoException{		
		try {			
			game.makeMove(StrategoPieceType.FLAG, null, c[5][5], StrategoPlayerColor.RED);
			game.makeMove(StrategoPieceType.FLAG, c[5][5], c[4][5], null);
			assertEquals(null, game.getBoard().GetBoard()[4][5].getPieceType());
			assertEquals(StrategoPieceType.FLAG, game.getBoard().GetBoard()[5][5].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	@Test(expected = StrategoException.class)
	public void testFlagMovementMultipleSquares() throws StrategoException{		
		try {			
			game.makeMove(StrategoPieceType.FLAG, null, c[5][5], StrategoPlayerColor.RED);
			game.makeMove(StrategoPieceType.FLAG, c[5][5], c[3][5], null);
			assertEquals(null, game.getBoard().GetBoard()[3][5].getPieceType());
			assertEquals(StrategoPieceType.FLAG, game.getBoard().GetBoard()[5][5].getPieceType());
		} catch (StrategoException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	@Test(expected = StrategoException.class)
	public void testRegUnitMovementDiagonal() throws StrategoException {			
		try {
				assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());
				game.makeMove(StrategoPieceType.ONE, c[2][0], c[3][1], null);
				assertEquals(null , game.getBoard().GetBoard()[3][1].getPieceType());
				assertEquals(StrategoPieceType.ONE , game.getBoard().GetBoard()[2][0].getPieceType());
			} catch (StrategoException e) {
				System.out.println(e.getMessage());
				throw e;
			}		
	}
	
}
