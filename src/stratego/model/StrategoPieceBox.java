package stratego.model;

import java.util.HashMap;

import stratego.util.StrategoPieceType;

public class StrategoPieceBox {
	//A Class used to hold pieces when placing, and eventually hold pieces that have been taken
	
	@SuppressWarnings("serial")
	private HashMap<StrategoPieceType, Integer> pieces = new HashMap<StrategoPieceType, Integer>(){{
		put(StrategoPieceType.ONE, 10);
		put(StrategoPieceType.TWO, 10);
		put(StrategoPieceType.THREE, 10);
		put(StrategoPieceType.FOUR, 10);
		put(StrategoPieceType.FIVE, 10);
		put(StrategoPieceType.SIX, 10);		
		put(StrategoPieceType.SEVEN, 10);
		put(StrategoPieceType.EIGHT, 10);
		put(StrategoPieceType.SPY, 10);
		put(StrategoPieceType.FLAG, 10);
		put(StrategoPieceType.BOMB, 10);
	}};
		
	public boolean isAvailable(StrategoPieceType pieceType){
		if(pieces.get(pieceType) > 0){
			pieces.put(pieceType, (pieces.get(pieceType)-1));
			return true;
		}		
		return false;
	}
	
	public int getNumOfPieces(StrategoPieceType pieceType){
		return pieces.get(pieceType);
	}

}
