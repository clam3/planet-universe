//possibly a control manager class
package javagame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class PlanetUniverse implements Game {
	
	
	private GameState gameState;
	private Menu menu;
	
	public boolean closeRequested() {
		return true;
	}

	public String getTitle() {
		return "Planet Universe!";
	}

	// set inital state
	public void init(GameContainer gc) throws SlickException {
		gameState = GameState.LOADING_MENU;;
		gc.setMinimumLogicUpdateInterval(1);
		gc.setMaximumLogicUpdateInterval(1);
		
	}

	public void update(GameContainer arg0, int arg1) throws SlickException {

		
	}
	
	// in the state of loading_menu but have to wait until first call of render 
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (gameState == GameState.MAIN_MENU) {
			menu.render(gc, g);
		} else if (gameState == GameState.LOADING_MENU ) {
			menu = new Menu();
			gameState = GameState.MAIN_MENU;
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
