package test.stratego.model;

import org.junit.Before;
import org.junit.Test;

import stratego.model.StrategoFactory;
import stratego.model.StrategoGameImp;

public class TestStrategoGameImp {
	StrategoGameImp game;
	@Before //Will run before every single test
	public void setup(){
		//game = (StrategoGameImp) StrategoFactory.getInstance().getGame();
		game = new StrategoGameImp();
	}
	@Test
	public void testConstructor(){
		
	}
}
