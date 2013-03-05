package stratego.model;

import stratego.common.StrategoException;
import stratego.common.StrategoGame;
import stratego.util.MoveResult;
import stratego.util.StrategoCoordinate;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

public class StrategoGameImp implements StrategoGame{

	protected StrategoState state;
	protected StragegoRuleSet ruleset;
	
	@Override
	public void initialize(StrategoPlayerColor firstPlayer)
			throws StrategoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MoveResult makeMove(StrategoPieceType pieceType,
			StrategoCoordinate from, StrategoCoordinate to)
			throws StrategoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrintableBoard() {
		// TODO Auto-generated method stub
		return null;
	}

}
