package javagame;

import org.newdawn.slick.AppGameContainer;

import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import strawberry.level.Level;
import strawberry.menu.Credits;
import strawberry.menu.Menu;
import strawberry.state.GameState;
import strawberry.state.PlanetUniverseState;

/**
 * Main class. Has main method.
 *
 */
public class PlanetUniverse implements Game {
	
	private Menu menu;
	private Credits credits;
	private Level level;
	
	/**
	 * Notification that a game close has been requested.
	 */
	public boolean closeRequested() {
		return true;
	}
	
	/**
	 * Returns the title
	 */
	public String getTitle() {
		return "Planet Universe!";
	}

	/**
	 * Initalise the game (load static resources). Called before
	 * the game loop starts.
	 */
	public void init(GameContainer gc) throws SlickException {
		PlanetUniverseState.setGameState(GameState.LOADING_MENU); // set 
		gc.setMinimumLogicUpdateInterval(1);
		gc.setMaximumLogicUpdateInterval(1);
		
	}
	
	/**
	 * Update the game logic here.
	 */
	public void update(GameContainer gc, int delta) throws SlickException {
		if (PlanetUniverseState.getGameState() == GameState.MAIN_MENU) { //if in main_menu, basically show buttons for it / act like a menu
			menu.update(gc, delta);
		} else if (PlanetUniverseState.getGameState() == GameState.CREDIT_MENU) { 
			credits.update(gc, delta);
		} else if (PlanetUniverseState.getGameState() == GameState.IN_UNIVERSE) {
			float nextTick = delta / 1000.0f; //miliseconds :D 
			// cry here
		}
	}
	
	/**
	 * Render the game's screen here
	 */
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (PlanetUniverseState.getGameState() == GameState.LOADING_MENU ) { // if "loading menu", make the menu and set state to it
		menu = new Menu();
		PlanetUniverseState.setGameState(GameState.MAIN_MENU);
		} 
		
		else if (PlanetUniverseState.getGameState() == GameState.MAIN_MENU) { // render menu if you are in the main menu
			menu.render(gc, g);
		} 
		
		else if (PlanetUniverseState.getGameState() == GameState.LOADING_CREDIT_MENU ) { //if "loading credit", make the credit menu and change states
			credits = new Credits();
			menu = null;
			PlanetUniverseState.setGameState(GameState.CREDIT_MENU);
		}
		
		else if (PlanetUniverseState.getGameState() == GameState.CREDIT_MENU ) { //if in the credit menu, render it
			credits.render(gc, g);
			PlanetUniverseState.setGameState(GameState.CREDIT_MENU);
		}
		
		else if (PlanetUniverseState.getGameState() == GameState.LEVEL_TRANSITION) { //if loading the game, create the game and change states
			level = new Level(gc);
			level.load(gc);
			PlanetUniverseState.setGameState(GameState.IN_UNIVERSE);
		}
		
		else if (PlanetUniverseState.getGameState() == GameState.IN_UNIVERSE) { //render universe if in universe
			level.render(gc, g);
		}
	}

	/**
	 * Woot. Main method :D
	 * @param args
	 */
	public static void main(String[] args) {
		//build actual window
		try {
			AppGameContainer container = new AppGameContainer(new PlanetUniverse());
			container.setDisplayMode(900,600,false);
			container.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
}
