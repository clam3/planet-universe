//ep 15
package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	public static final String gamename = "Planet Universe!";
	//each state will be a different class (so a menu & play class)
	public static final int menu = 0;
	public static final int play = 1;
	public static final int credits = 2;
	
	public Game(String gamename) { //constructor
		super(gamename); //going to say game title on top of the screen
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Credits(credits));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException { //abstract class that had to be made, manages behind the scenes stuff
		this.getState(menu).init(gc, this); // two states of this game, menu and play
		this.getState(play).init(gc, this);
		this.getState(credits).init(gc, this);
		this.enterState(menu);
	}
	
	public static void main(String[] args) {
		//build actual window
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gamename)); // container is going to hold a new game
			appgc.setDisplayMode(900, 600, false);// set size of window (length, width, fullscreen?)
			appgc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
}
