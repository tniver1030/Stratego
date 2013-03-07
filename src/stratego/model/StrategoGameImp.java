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
		state = new StrategoState();
		ruleset = new StrategoRuleSet(state);

	}
	
	@Override
	public void initialize(StrategoPlayerColor firstPlayer)
			throws StrategoException {

		
	}

	@Override
	public MoveResult makeMove(StrategoPieceType pieceType,	StrategoCoordinate from, StrategoCoordinate to)	throws StrategoException {

		ruleset.PerformPremoveChecks(pieceType, from, to); //TODO finish all checks
		ruleset.doMove(pieceType, from, to);
		//TODO determine if player won
		return null;
	}

	@Override
	public String getPrintableBoard() {

		return null;
	}

}
