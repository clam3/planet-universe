package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Menu {
	
	public String mouse = "No input yet!";
	Image title, play, credits, exit;
	int faceX = 100;
	int faceY = 100;
	
	public Menu() {
		try {
			title = new Image("res/menu-buttons/Planet-Universe.png");
			play = new Image("res/menu-buttons/Play.png");
			credits = new Image("res/menu-buttons/Credits.png");
			exit = new Image("res/menu-buttons/Exit.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException{ //actually draws stuff on the screen
		g.drawString(mouse, 50, 50); // text with mouse position
		
		// 200 x 75 png images
		g.drawImage(title, 300, 50);
		g.drawImage(play, 350, 250);
		g.drawImage(credits, 350, 350);
		g.drawImage(exit, 350, 450);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{ //updates the images on the screen, ie animation
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "Mouse position x: " + xpos + " y: " + ypos;
		
		Input input = gc.getInput();
		//check if it's in the play button
		if ((xpos>350 && xpos<550) && (ypos>275 && ypos<350)) {
			if (input.isMouseButtonDown(0)) { // is clicking mouse button? 0 = left click
				sbg.enterState(1); //enter Play.java
			}
		}
		
		//check if it's in the credits button
		if ((xpos>350 && xpos<550) && (ypos>175 && ypos<250)) {
			if (input.isMouseButtonDown(0)) { // is clicking mouse button? 0 = left click
				sbg.enterState(2); //enter Credits.java
			}
		}
		
		//check if it's in the exit button
		if ((xpos>350 && xpos<550) && (ypos>75 && ypos<150)) {
			if (input.isMouseButtonDown(0)) { // is clicking mouse button? 0 = left click
				System.exit(0); //quit normally
			}
		}
	}
	
	public int getID() {
		return 0;
	}
	
}
