package stratego.model;

import stratego.common.StrategoException;
import stratego.util.StrategoCoordinate;
import stratego.util.StrategoPieceType;

public class StrategoRuleSet {
	protected StrategoState state;
	public StrategoRuleSet(StrategoState state){
		this.state = state;
	}
	
	public void PerformPremoveChecks(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to){
		try { 
		checkGameIsRunning();
		checkDestinationValid(pieceType, from, to);
		} catch (StrategoException e) {
			e.printStackTrace();
		}
		
		//Ensure piecetype is valid
		//Ensure that destination is valid
		
	}
	private void checkGameIsRunning() throws StrategoException{
		if(state.IsGameOver()){
			throw new StrategoException("Game has ended");
		}
	}
	
	public void checkDestinationValid(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException{
		//Verify player who is making move has their piece there
		state.canMove(pieceType, from, to);
	}

	public void doMove(StrategoPieceType pieceType, StrategoCoordinate from, StrategoCoordinate to) throws StrategoException {
		state.doMove(pieceType, from, to);
		
	}
}