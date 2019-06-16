//possibly a control manager class
package javagame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import strawberry.menu.Credits;
import strawberry.menu.Menu;
import strawberry.state.GameState;
import strawberry.state.PlanetUniverseState;

public class PlanetUniverse implements Game {
	
	private Menu menu;
	private Credits credits;
	
	/**
	 * Notification that a game close has been requested.
	 */
	public boolean closeRequested() {
		return true;
	}

	public String getTitle() {
		return "Planet Universe!";
	}

	/**
	 * Initalise the game (load static resources). Called before
	 * the game loop starts.
	 */
	public void init(GameContainer gc) throws SlickException {
		PlanetUniverseState.setGameState(GameState.LOADING_MENU);
		gc.setMinimumLogicUpdateInterval(1);
		gc.setMaximumLogicUpdateInterval(1);
		
	}
/**
 * Update the game logic here.
 */
	public void update(GameContainer gc, int delta) throws SlickException {
		if (PlanetUniverseState.getGameState() == GameState.MAIN_MENU) {
			menu.update(gc, delta);
		} else if (PlanetUniverseState.getGameState() == GameState.CREDIT_MENU) {
			credits.update(gc, delta);
		}
		
	}
	
	/**
	 * Render the game's screen here
	 */
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (PlanetUniverseState.getGameState() == GameState.MAIN_MENU) {
			menu.render(gc, g);
			
		} else if (PlanetUniverseState.getGameState() == GameState.LOADING_MENU ) {
			menu = new Menu();
			PlanetUniverseState.setGameState(GameState.MAIN_MENU);
			
		} else if (PlanetUniverseState.getGameState() == GameState.LOADING_CREDIT_MENU ) {
			credits = new Credits();
			menu = null;
			PlanetUniverseState.setGameState(GameState.CREDIT_MENU);
			
		} else if (PlanetUniverseState.getGameState() == GameState.CREDIT_MENU ) {
			credits.render(gc, g);
			PlanetUniverseState.setGameState(GameState.CREDIT_MENU);
		}
	}

	
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
