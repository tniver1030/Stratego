package stratego.model;

import stratego.common.StrategoException;
import stratego.util.StrategoCoordinate;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

//Anything that doesnt need the state will be executed here

public class StrategoRuleSet {
	protected StrategoState state;
	public StrategoRuleSet(StrategoState state){
		this.state = state;
	}
	
	public void PerformPremoveChecks(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException{ //Checks to make sure is valid move
		
		checkGameIsRunning(); //TODO finish checking if game is running, edit state when done
		checkDestinationValid(pieceType, from, to);
		checkValidPieceType(pieceType); //Verifies that it is a piece that can move		
		checkValidMove(pieceType, from, to); //Makes sure piece can move that far
			
	}

	private void checkGameIsRunning() throws StrategoException{
		if(!state.IsGameOver()){
			throw new StrategoException("Game has ended");
		}
	}
	
	private void checkDestinationValid(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException{		
		state.canMove(pieceType, from, to);//Verify player who is making move has their piece there
	}

	public void doMove(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to, StrategoPlayerColor playerColor) throws StrategoException {//does move
		state.doMove(pieceType, from, to, playerColor);		
	}
	private void checkValidMove(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException{
		state.checkValidMove(pieceType, from, to);
	}
	public void checkWon(){
		//TODO Check if both flags are still alive
	}
	
	private void checkValidPieceType(StrategoPieceType pieceType) throws StrategoException{ //verifies that the specified piece can move
		if(pieceType == StrategoPieceType.BOMB){
			throw new StrategoException("Bombs cannot move");
		}
		if(pieceType == StrategoPieceType.FLAG){
			throw new StrategoException("Flags cannot move");
		}
	}
}