package stratego.model;

import stratego.common.StrategoException;
import stratego.util.MoveResult;
import stratego.util.StrategoCoordinate;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

//TODO fill in comments

public class StrategoRuleSet {
	
	protected StrategoState state;
	
	public StrategoRuleSet(StrategoState state){
		this.state = state;
	}
	
	/**
	 * This method verifies that everything is able to run. Used to make sure there are no errors
	 * 
	 * @param pieceType
	 *            the piece type that you are moving
	 * @param from
	 * 			  the coordinates that you are moving from
	 * @param to
	 * 			  the coordinates that you are moving to
	 * @throws StrategoExcception
	 * 			 used if there are any issues
	 */
	public void PerformPremoveChecks(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException{ //Checks to make sure is valid move
		
		checkGameIsRunning(); //Makes sure game isnt over
		checkDestinationValid(pieceType, from, to); //Makes sure destination is valid
		checkValidPieceType(pieceType); //Verifies that it is a piece that can move		
		checkValidMove(pieceType, from, to); //Makes sure piece can move that far
			
	}
	
	/**
	 * This method verifies that everything is able to run. Used to make sure there are no errors
	 * 
	 * @param pieceType
	 *            the piece type that you are moving
	 * @param from
	 * 			  the coordinates that you are moving from
	 * @param to
	 * 			  the coordinates that you are moving to
	 * @throws StrategoExcception
	 * 			 used if there are any issues
	 */
	public MoveResult checkWhoWon(){
		return state.getGameStatus();
	}
	
	/**
	 * This method verifies that everything is able to run. Used to make sure there are no errors
	 * 
	 * @param pieceType
	 *            the piece type that you are moving
	 * @param from
	 * 			  the coordinates that you are moving from
	 * @param to
	 * 			  the coordinates that you are moving to
	 * @throws StrategoExcception
	 * 			 used if there are any issues
	 */
	public void doMove(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to, StrategoPlayerColor playerColor) throws StrategoException {//does move
		state.doMove(pieceType, from, to, playerColor);		
	}
	
	//
	private void checkGameIsRunning() throws StrategoException{
		if(checkWhoWon() == MoveResult.BLUE_WINS){
			throw new StrategoException("Game has ended, blue won");
		}
		if(checkWhoWon()  == MoveResult.RED_WINS){
			throw new StrategoException("Game has ended, Red Won");
		}
		if(checkWhoWon()  == MoveResult.DRAW){
			throw new StrategoException("Game has ended, Tie game");
		}
		
	}
	
	//
	private void checkDestinationValid(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException{		
		state.canMove(pieceType, from, to);//Verify player who is making move has their piece there
	}
	
	//
	private void checkValidMove(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException{
		state.checkValidMove(pieceType, from, to);
	}
	
	//	
	private void checkValidPieceType(StrategoPieceType pieceType) throws StrategoException{ //verifies that the specified piece can move
		if(pieceType == StrategoPieceType.BOMB){
			throw new StrategoException("Bombs cannot move");
		}
		if(pieceType == StrategoPieceType.FLAG){
			throw new StrategoException("Flags cannot move");
		}
	}
}