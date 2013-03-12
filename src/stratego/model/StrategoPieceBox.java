package stratego.model;

import java.util.HashMap;

import stratego.common.StrategoException;
import stratego.util.StrategoPieceType;

public class StrategoPieceBox {
	//A Class used to hold pieces when placing, and eventually hold pieces that have been taken
	//Will be created once, for each color
	
	@SuppressWarnings("serial")
	private HashMap<StrategoPieceType, Integer> pieces = new HashMap<StrategoPieceType, Integer>(){{ //Hasmap of all pieces, and associate count
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
	
	/**
	 * This method checks whether or not there any specific pieces remaining. If so, returns true and decreases count
	 * 
	 * @param pieceType
	 *            the piece type that you are placing
	 * @return whether or not there are any of those pieces left
	 */
	public boolean isAvailable(StrategoPieceType pieceType){
		if(pieces.get(pieceType) > 0){
			pieces.put(pieceType, (pieces.get(pieceType)-1));
			return true;
		}		
		return false;
	}
	
	/**	 
	 * This method is used after all pieces are placed normally, and is used to see the number of specified pieces off of the board
	 * 
	 * @param pieceType
	 *            the piece type that you want to know the count of
	 * @return the number of pieces remaining
	 */
	public int getNumOfPieces(StrategoPieceType pieceType){
		return pieces.get(pieceType);
	}

}
