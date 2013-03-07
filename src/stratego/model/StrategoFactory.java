package stratego.model;

import stratego.common.StrategoGame;

public class StrategoFactory {	//An object that just creates instances of other objects, singleton
	private static final StrategoFactory instance = new StrategoFactory();
	private static StrategoGameImp game;
	private StrategoFactory(){
		game = new StrategoGameImp();
	}
	public static StrategoFactory getInstance(){
		return instance;
	}
	public StrategoGameImp getGame(){
		return game;
	}
}
