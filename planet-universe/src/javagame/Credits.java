package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Credits extends BasicGameState{
	Image back;
	
	public Credits(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		back = new Image("res/menu-buttons/Back.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{ //actually draws stuff on the screen
		g.drawString("Credit Screen :D", 100, 100);
		g.drawImage(back, 350, 450);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{ //updates the images on the screen, ie animation
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		Input input = gc.getInput();
		
		//check if it's in the back button
		if ((xpos>350 && xpos<550) && (ypos>75 && ypos<150)) {
			if (input.isMouseButtonDown(0)) { // is clicking mouse button? 0 = left click
				sbg.enterState(0); //enter Menu.java
				//>ERROR< EXITS INSTEAD OF BACK
			}
		}
	}
	
	public int getID() {
		return 2;
	}
	
}