package stratego.model;

import stratego.common.StrategoException;
import stratego.common.StrategoGame;
import stratego.util.MoveResult;
import stratego.util.StrategoCoordinate;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

public class StrategoGameImp implements StrategoGame{

	protected StrategoState state;
	protected StrategoRuleSet ruleset;
	
	public StrategoGameImp(){
		state = new StrategoState(); //Init state, holds the board
		ruleset = new StrategoRuleSet(state); //Gives ruleset the proper state

	}
	
	@Override
	public void initialize(StrategoPlayerColor firstPlayer)
			throws StrategoException {		
	}

	@Override
	public MoveResult makeMove(StrategoPieceType pieceType,	StrategoCoordinate from, StrategoCoordinate to, StrategoPlayerColor playerColor)	throws StrategoException {
		if(from != null){
			ruleset.PerformPremoveChecks(pieceType, from, to); //Makes sure valid
			ruleset.doMove(pieceType, from, to, playerColor);	//Does move, and puts winning piece in place
			ruleset.checkWhoWon();	//Makes sure its not game over
		}
		else{
			//TODO make performpremovechecks for placement
			ruleset.doMove(pieceType, from, to, playerColor);
		}
		return null;
	}

	@Override
	public String getPrintableBoard() {
		return null;
	}
	/**
	 * @return the state
	 */
	public StrategoBoard getBoard() {
		return state.board;
	}

}
