package stratego.model;

import stratego.common.StrategoException;
import stratego.util.MoveResult;
import stratego.util.StrategoCoordinate;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

public class StrategoState {
	//turn, board, etc
	//Generate setup
	StrategoBoard board;
	MoveResult gameStatus = MoveResult.OK;
	StrategoPlayerColor playerTurn = StrategoPlayerColor.RED; //goes first
	
	public StrategoState(){
		board = new StrategoBoard();
	}	
	public boolean IsGameOver(){
		if(gameStatus != MoveResult.OK){
			return true;
		}
		else{
			return false; //Game ended
		}
		
	}
	public void canMove(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException {
		//Make sure to is empty, make sure the piece at from is correct color and piece type
		if(!board.GetBoard()[to.getX()][to.getY()].isEmpty()){
			throw new StrategoException("Location to is not empty");			
		}
		if(board.GetBoard()[from.getX()][from.getY()].isEmpty()){
			throw new StrategoException("Location moving from is empty!");			
		}
	}
	
	public void doMove(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException{
		board.GetBoard()[from.getX()][from.getY()].DePopulate();
		board.GetBoard()[to.getX()][to.getY()].Populate(playerTurn, pieceType);
		if(playerTurn == StrategoPlayerColor.RED){
			playerTurn = StrategoPlayerColor.BLUE;
		}
		else{
			playerTurn = StrategoPlayerColor.RED;
		}
	}
}
