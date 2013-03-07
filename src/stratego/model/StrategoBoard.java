package stratego.model;

import stratego.common.StrategoException;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;


/**
 * Objects that have piece, color, location
 * @author Taylor
 * Just knows pieces and places, colors
 */
public class StrategoBoard {
	
	private StrategoBoardLocation board[][] = new StrategoBoardLocation[10][10];

	
	public StrategoBoard(){
		//Creates all pieces
		for(int i = 0; i <=9; i++){
			for(int j = 0; j<=9; j++){
				try {
					board[i][j] = new StrategoBoardLocation(i, j);
				} catch (StrategoException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			board[1][3].Populate(StrategoPlayerColor.RED, StrategoPieceType.FIVE);			
		} catch (StrategoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public StrategoBoardLocation[][] GetBoard(){
		return board;		
	}
}
