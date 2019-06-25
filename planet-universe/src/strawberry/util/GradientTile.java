/**
 * 
 */
package strawberry.util;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import strawberry.world.WorldTile;

/**
 * @author chris
 *
 */
public class GradientTile extends WorldTile {
	
	private Image gradientTileImg;
	
	/**
	 * @param x
	 * @param y
	 */
	public GradientTile(int x, int y, Image tileImg) {
		super(x, y);
		this.gradientTileImg = tileImg;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawWorldTile(Graphics g) {
		g.drawImage(this.gradientTileImg, this.xPos * this.worldTileSize, this.yPos * this.worldTileSize);
	}
	
	/**
	 * don't render if not in view (delete tile if not in view)
	 * @throws Exception 
	 */
	public void clearWorldTile() throws Exception {
		this.gradientTileImg.destroy();
	}
}
