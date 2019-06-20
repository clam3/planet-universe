package strawberry.star;

import org.newdawn.slick.Graphics;

/**
 * A Star is an image with an x and y position that is stored as a Vector Tile
 */
import org.newdawn.slick.Image;

import strawberry.util.VectorTile;

public class Star {
	private VectorTile starPosition;
	private Image starImg;
	
	public Star(float x, float y, Image img) {
		this.starPosition = new VectorTile(x,y);
		this.starImg = img;
	}
	
	public void draw(Graphics g) {
		g.drawImage(this.starImg, starPosition.getxTilePos(), starPosition.getyTilePos());
	}


}
