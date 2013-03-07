package stratego.model;

import stratego.util.StrategoCoordinate;

public class StrategoCoordImp implements StrategoCoordinate {
	private final int x;
	private final int y;	
	public StrategoCoordImp(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

}
