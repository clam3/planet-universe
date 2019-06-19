package strawberry.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * control basic things in the layer
 * @author chris
 *
 */

public abstract class TileLayer {
		protected float windowScale;
		public int layerWidth;
		public int layerHeight;
		
		public TileLayer(float windowScale, GameContainer gc) {
			this.windowScale = windowScale;
			this.layerHeight = gc.getHeight();
			this.layerWidth = gc.getWidth();
		}
		
		public abstract void draw(Graphics g, float xPos, float yPos);
}

//beep beep oink oink im a robot yeet 