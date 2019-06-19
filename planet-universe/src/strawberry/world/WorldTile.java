package strawberry.world;

import org.newdawn.slick.Graphics;

public abstract class WorldTile {
	
	public static int worldTileSize = 128; //how many pixels in each tile :D
	public int xPos;
	public int yPos;
	
	public WorldTile(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public boolean shouldStorePos(float xPos, float yPos, float width, float height) {
		int scaleTileX = this.xPos * WorldTile.worldTileSize;
		int scaleTileY = this.yPos * WorldTile.worldTileSize;
		float scaleTileDistanceX = Math.max(xPos - (scaleTileX + WorldTile.worldTileSize), scaleTileX - (xPos + width)); //scale it
		float scaleTileDistanceY = Math.max(yPos - (scaleTileY + WorldTile.worldTileSize), scaleTileY - (yPos + height));
		boolean shouldStorePos = false;
		if (scaleTileDistanceX <= WorldTile.worldTileSize * 2 && scaleTileDistanceY <= WorldTile.worldTileSize * 2) { 
			shouldStorePos = true;
		}
		return shouldStorePos;
		// want to store stuff if it's twice the distance in front of the user
		// only want to store the ones that aren't visible and are generated
	}
	
	public static int worldTileHash(int xPos, int yPos) {
		int worldTileHash = xPos * 100 + yPos;
		return worldTileHash;
	}
	public abstract void drawWorldTile(Graphics g);
}
