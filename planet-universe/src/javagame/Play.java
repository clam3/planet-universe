package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	boolean quit = false;
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{ //actually draws stuff on the screen
		g.drawString("Play Screen :D", 250, 50);
		
		//escape menu
		if (quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit Game (Q)", 250, 200);
			if (quit == false) {
				g.clear();
			}
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{ //updates the images on the screen, ie animation
		Input input = gc.getInput();
		//escape menu stuff
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}
		//when the menu is up
		if (quit == true) {
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			if (input.isKeyDown(Input.KEY_M)) {
				sbg.enterState(0);
			}
			if (input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);
			}
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}