package strawberry.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class TileLayer {
		private float windowScale;
		private int layerWidth;
		private int layerHeight;
		
		public TileLayer(float windowScale, GameContainer gc) {
			this.windowScale = windowScale;
			this.layerHeight = gc.getHeight();
			this.layerWidth = gc.getWidth();
		}
		
		public abstract void draw(Graphics g, float xPos, float yPos);
}