package test.stratego.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import stratego.common.StrategoException;
import stratego.model.StrategoCoordImp;
import stratego.model.StrategoGameImp;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

public class TestStrategoGameCombat {
	
	StrategoGameImp game;
	StrategoCoordImp c[][] = new StrategoCoordImp[10][10];
	
	@Before
	public void setupBoard() throws StrategoException{
		game = new StrategoGameImp();	
		for(int i = 0; i <= 9; i++){
			for(int j = 0; j < 9; j++){
				c[i][j] = new StrategoCoordImp(i, j);
			}
		}			
		//Place pieces
		game.makeMove(StrategoPieceType.ONE, null, c[0][0], StrategoPlayerColor.RED);	
		game.makeMove(StrategoPieceType.TWO, null, c[1][0], StrategoPlayerColor.RED);
		game.makeMove(StrategoPieceType.ONE, null, c[0][1], StrategoPlayerColor.BLUE);
		game.makeMove(StrategoPieceType.THREE, null, c[1][1], StrategoPlayerColor.BLUE);
		game.makeMove(StrategoPieceType.ONE, null, c[2][0], StrategoPlayerColor.BLUE);
		/*
		 * |
		 * |
		 * |B1|B3|  |  | 
		 * |R1|R2|B1|  |  
		 */
	}
	
	@Test
	public void testAttackingTeammates(){
		System.out.print("Attacking Own Lower Pieces:");
		moveFail(StrategoPieceType.ONE, 0,0,1,0);
	}
	@Test
	public void testAttackingHigherTeammates(){
		System.out.print("Attacking Own Higher Pieces:");
		moveFail(StrategoPieceType.TWO, 1, 0, 0,0 );
	}
	@Test
	public void attackEnemySameLevel(){
		System.out.print("Attacking Enemy Same Pieces:");
		moveSucceedTie(StrategoPieceType.ONE, 0,0, 0, 1);
	}
	@Test
	public void attackEnemyHigherLevel(){
		System.out.print("Attacking Enemy Higher Pieces:");
		moveSucceedLose(StrategoPieceType.TWO, 1,0,2,0);
	}
	@Test
	public void attackEnemyLowerLevel(){
		System.out.print("Attacking Enemy Lower Pieces:");
		moveSucceedWin(StrategoPieceType.TWO, 1, 0, 1, 1);
	}
	@Test
	public void attackEnemyLowerLevelBlue(){
		System.out.print("Blue is attacking Enemy Lower Pieces:");
		moveSucceedWin(StrategoPieceType.ONE, 2,0,1,0);
	}
	@Test
	public void attackEnemyHigherLevelBlue(){
		System.out.print("Blue is attacking Enemy Higher Pieces:");
		moveSucceedLose(StrategoPieceType.THREE, 1, 1, 1, 0);
	}
	
	
	
	private void moveFail(StrategoPieceType attacker,int fx,int fy,int tx,int ty){
		StrategoPieceType defender = game.getBoard().GetBoard()[tx][ty].getPieceType();
		assertEquals(attacker, game.getBoard().GetBoard()[fx][fy].getPieceType());
		try {			
			game.makeMove(attacker ,c[fx][fy] , c[tx][ty], null);			
		} catch (StrategoException e) { //Should always run
			System.out.println(e.getMessage()); //Prints message to verify error
			//throw e;
			assertEquals(attacker, game.getBoard().GetBoard()[fx][fy].getPieceType());
			assertEquals(defender, game.getBoard().GetBoard()[tx][ty].getPieceType());
		}
	}
	private void moveSucceedWin(StrategoPieceType attacker,int fx,int fy,int tx,int ty){
		StrategoPieceType defender = game.getBoard().GetBoard()[tx][ty].getPieceType();
		assertEquals(attacker, game.getBoard().GetBoard()[fx][fy].getPieceType());
		try {
			game.makeMove(attacker, c[fx][fy], c[tx][ty], null);
			assertEquals(attacker, game.getBoard().GetBoard()[tx][ty].getPieceType());
			assertEquals(null, game.getBoard().GetBoard()[fx][fy].getPieceType());
			System.out.println("Success");
		} catch (StrategoException e) {
			System.out.println("Should have Succeeded in running but didnt "+ e.toString());
		}
	}
	private void moveSucceedLose(StrategoPieceType attacker,int fx,int fy,int tx,int ty){
		StrategoPieceType defender = game.getBoard().GetBoard()[tx][ty].getPieceType();
		assertEquals(attacker, game.getBoard().GetBoard()[fx][fy].getPieceType());
		try {
			game.makeMove(attacker, c[fx][fy], c[tx][ty], null);
			assertEquals(defender, game.getBoard().GetBoard()[tx][ty].getPieceType());
			assertEquals(null, game.getBoard().GetBoard()[fx][fy].getPieceType());
			System.out.println("Success");
		} catch (StrategoException e) {
			System.out.println("Should have Succeeded in running but didnt "+ e.toString());
		}
	}
	private void moveSucceedTie(StrategoPieceType attacker,int fx,int fy,int tx,int ty){
		StrategoPieceType defender = game.getBoard().GetBoard()[tx][ty].getPieceType();
		assertEquals(attacker, game.getBoard().GetBoard()[fx][fy].getPieceType());
		try {
			game.makeMove(attacker, c[fx][fy], c[tx][ty], null);
			assertEquals(null, game.getBoard().GetBoard()[tx][ty].getPieceType());
			assertEquals(null, game.getBoard().GetBoard()[fx][fy].getPieceType());
			System.out.println("Success");
		} catch (StrategoException e) {
			System.out.println("Should have Succeeded in running but didnt: " + e.toString());
		}
	}
}
