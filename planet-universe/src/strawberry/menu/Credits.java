package strawberry.menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import strawberry.state.GameState;
import strawberry.state.PlanetUniverseState;

public class Credits {
	Image back;
	
	public Credits() {
		try {
			back = new Image("res/menu-buttons/Back.png");
		} catch (SlickException e) {
		    e.printStackTrace();
		}
	}
	
	public void init(GameContainer gc) throws SlickException{
		
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException{ //actually draws stuff on the screen
		g.drawString("Credit Screen :D", 100, 100);
		g.drawImage(back, 350, 450);
	}
	
	public void update(GameContainer gc, int delta) throws SlickException{ //updates the images on the screen, ie animation
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		Input input = gc.getInput();
		
		//check if it's in the back button
		if ((xpos>350 && xpos<550) && (ypos>75 && ypos<150)) {
			if (input.isMouseButtonDown(0)) { // is clicking mouse button? 0 = left click
				//sbg.enterState(Game.menu); 
				PlanetUniverseState.setGameState(GameState.LOADING_MENU);
			}
		}
	}
		
}