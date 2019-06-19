package strawberry.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import strawberry.star.StarCanvas;

public class World {

	private StarCanvas starCanvas;
	
	public World(GameContainer gc) {
		starCanvas = new StarCanvas(gc);
	}
	
	public void render(GameContainer gc, Graphics g) {
		starCanvas.draw(g, 118, 54);
	}
}
