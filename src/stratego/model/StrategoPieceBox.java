package stratego.model;

import stratego.util.StrategoPieceType;

public class StrategoPieceBox {
	//A Class used to hold pieces when placing, and eventually hold pieces that have been taken
	private int numOfOnes = 10,
	 numOfTwos = 10,
	 numOfThrees = 10,
	 numOfFours = 10,
	 numOfFives = 10,
	 numOfSixes = 10,
	 numOfSevens = 10,
	 numOfEights = 10,
	 numOfSpys = 10,
	 numOfFlags = 10,
	 numOfBombs = 10;
	
	public StrategoPieceBox(){	//TODO fill with gamemodes and corresponding piece types.
		
	}
	public boolean isAvailable(StrategoPieceType pieceType){
		if(pieceType == StrategoPieceType.ONE){
			if(numOfOnes > 0){
				numOfOnes --;
				return true;	
			}
			else{ return false;}
		}
		else if(pieceType == StrategoPieceType.TWO){
			if(numOfTwos > 0){
				numOfTwos --;
				return true;
			}
			else{return false;}
		}
		else if(pieceType == StrategoPieceType.THREE){
			if(numOfThrees > 0){
				numOfThrees --;
				return true;
			}
			else{ return false; }
		}
		else if(pieceType == StrategoPieceType.FOUR){
			if(numOfFours > 0){
				numOfFours--;
				return true;
			}
			else{return false; }
		}
		else if(pieceType == StrategoPieceType.FIVE){
			if(numOfFives > 0){
				numOfFives--;
				return true;
			}
			else{ return false;}
		}
		else if(pieceType == StrategoPieceType.SIX){
			if(numOfSixes > 0){
				numOfSixes--;
				return true;
			}
			else{ return false;}
		}
		else if(pieceType == StrategoPieceType.SEVEN){
			if(numOfSevens > 0){
				numOfSevens--;
				return true;
			}
			else{ return false;}
		}
		else if(pieceType == StrategoPieceType.EIGHT){
			if(numOfEights > 0){
				numOfEights--;
				return true;
			}
			else{ return false;}
		}
		else if(pieceType == StrategoPieceType.SPY){
			if(numOfSpys > 0){
				numOfSpys--;
				return true;
			}
			else{ return false;}
		}
		else if(pieceType == StrategoPieceType.FLAG){
			if(numOfFlags > 0){
				numOfFlags--;
				return true;
			}
			else{ return false;}
		}
		else{//Bomb
			if(numOfBombs > 0){
				numOfBombs--;
				return true;
			}
			else{ return true;}
		}
			
	}

}
