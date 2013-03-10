package stratego.model;

import stratego.common.StrategoException;
import stratego.util.StrategoCoordinate;
import stratego.util.StrategoPieceType;
import stratego.util.StrategoPlayerColor;

public class StrategoBoardLocation implements StrategoCoordinate{
	
	private StrategoPieceType pieceType = null;
	private StrategoPlayerColor playerColor = null;
	private final StrategoCoordImp coord;
	private boolean placeable = true;
	
	public StrategoBoardLocation(int coordinateX, int coordinateY) throws StrategoException{
		if(coordinateX > 9 || coordinateX < 0 || coordinateY > 9 || coordinateY < 0){
			throw new StrategoException("Location indicated out of range");
		}
		//Defines all unmoveable locations
		coord = new StrategoCoordImp(coordinateX, coordinateY);
		if((coordinateX == 2 && coordinateY == 4) ||
			(coordinateX == 2 && coordinateY == 5) ||
			(coordinateX == 3 && coordinateY == 4) ||
			(coordinateX == 3 && coordinateY == 5) ||
			(coordinateX == 6 && coordinateY == 4) ||
			(coordinateX == 6 && coordinateY == 5) ||
			(coordinateX == 7 && coordinateY == 4) ||
			(coordinateX == 7 && coordinateY == 5)){
			placeable = false;		
		}
	}
	public StrategoBoardLocation(StrategoPieceType pieceType, StrategoPlayerColor playerColor, int coordinateX, int coordinateY) throws StrategoException{
		//Used to initialize board to a specific setup
		if(coordinateX > 9 || coordinateX < 0 || coordinateY > 9 || coordinateY < 0){
			throw new StrategoException("Location indicated out of range");
		}
		this.pieceType = pieceType;
		this.playerColor = playerColor;
		coord = new StrategoCoordImp(coordinateX, coordinateY);
		//check ranges
		//make sure not in water
		//
		//		
	}	
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return coord.getX();
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return coord.getY();
	}
	
	/**
	 * @return the pieceType
	 */
	public StrategoPieceType getPieceType() {
		return pieceType;
	}
		
	/**
	 * @return the playerColor
	 */
	public StrategoPlayerColor getPlayerColor() {
		return playerColor;
	}
	/**
	 * @param Pupulates location with color and type
	 * @throws StrategoException 
	 */
	public void Populate(StrategoPlayerColor playerColor, StrategoPieceType pieceType) throws StrategoException {
		//if null
		//if invalid location
		//if piece already there
		if(playerColor == null || pieceType == null){
			throw new StrategoException("Tried to set location to null");
		}
		if(!placeable){
			throw new StrategoException("Tried to place piece on water");
		}
		if(this.pieceType != null){
			throw new StrategoException("Tried to place piece in occupied spot");
		}
		this.playerColor = playerColor;
		this.pieceType = pieceType;
	}
	/**
	 * @throws StrategoException 
	 */
	public void DePopulate() throws StrategoException {
		if(!placeable){
			throw new StrategoException("Tried to place piece on water");
		}
		this.playerColor = null;
		this.pieceType = null;
	}
	/**
	 * @return the placeable
	 */
	public boolean isPlaceable() {
		return placeable;
	}
	
	public boolean isEmpty(){
		if(pieceType == null && playerColor == null){
			return true;
		}
		else{
			return false;
		}
	}
}
