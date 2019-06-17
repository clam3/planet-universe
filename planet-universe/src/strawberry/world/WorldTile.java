package strawberry.world;

import org.newdawn.slick.Graphics;

public abstract class WorldTile {
	
	public int worldTileSize = 128; //how many pixels in each tile :D
	public int xPos;
	public int yPos;
	
	public WorldTile(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public boolean shouldStorePos(float xPos, float yPos, float width, float height) {
		int scaleTileX = this.xPos * this.worldTileSize;
		int scaleTileY = this.yPos * this.worldTileSize;
		float scaleTileDistanceX = Math.max(xPos - (scaleTileX + this.worldTileSize), scaleTileX - (xPos + width)); //scale it
		float scaleTileDistanceY = Math.max(yPos - (scaleTileY + this.worldTileSize), scaleTileY - (yPos + height));
		boolean shouldStorePos = false;
		if (scaleTileDistanceX <= this.worldTileSize * 2 && scaleTileDistanceY <= this.worldTileSize * 2) { 
			shouldStorePos = true;
		}
		return shouldStorePos;
		// want to store stuff if it's twice the distance in front of the user
		// only want to store the ones that aren't visible and are generated
	}
	
	public abstract void drawWorldTile(Graphics g);
}
