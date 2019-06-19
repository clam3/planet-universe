package strawberry.level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import strawberry.world.World;

public class Level {
	
	private World starUniverse;
	
	public Level (GameContainer gc) {
		this.starUniverse = new World(gc);
		
	}
	
	public void load(GameContainer gc) {
		this.starUniverse = new World(gc);
		
	}
	
	public void updateWorld(float nextTick) {
		//starUniverse.update(nextTick);
	}
	
	public void render(GameContainer gc, Graphics g) {
		int gameContainerWidth = gc.getWidth();
		int gameContainerHeight = gc.getHeight();
		g.translate(gameContainerWidth / 2, gameContainerHeight / 2);
		g.scale(1.0f, -1.0f);
		this.starUniverse.render(gc, g);
		g.resetTransform(); // reset scaling
		g.translate(gameContainerWidth / 2, gameContainerHeight / 2);
		g.scale(1.0f, -1.0f);
	}
}
