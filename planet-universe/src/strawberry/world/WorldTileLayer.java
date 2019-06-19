package strawberry.world;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * basis for all the space layers :D eventually going to be stars, gases, planets, or whatever
 * they all get rendered the same way :D
 * @author chris
 *
 */
public abstract class WorldTileLayer extends TileLayer {
	
	private Map<Integer, WorldTile> worldTileMap;
	private int frameTileRenderRate = 10; // arbitary, u pick (game is like 10 ticks)
	private int lastFrameTileUpdate = 0 ;
	
	public WorldTileLayer(float windowScale, GameContainer gc) {
		super(windowScale, gc);
		this.worldTileMap = new HashMap<Integer, WorldTile>();
		
	}

	@Override
	public void draw(Graphics g, float xPos, float yPos) { 
		xPos = xPos * windowScale;
		yPos = yPos * windowScale;
		if (lastFrameTileUpdate == frameTileRenderRate) {
			if (worldTileMap.isEmpty()) { // don't store if it's empty
				update(xPos, yPos, true);
			} else {
				update(xPos, yPos, false);
			}
			lastFrameTileUpdate = 0;
		} else {
			lastFrameTileUpdate++;
		}
		xPos = xPos + (layerWidth / 2);
		yPos = yPos + (layerHeight / 2);
		g.translate(-xPos, -yPos); // draw left to right
		for (WorldTile worldTile : worldTileMap.values()) {
			worldTile.drawWorldTile(g);
		}
		g.translate(xPos, yPos); // unreverse the stuff
	}
	
	private void update(float xPos, float yPos, boolean storedTiles) { //calling update on every tick
		Iterator<WorldTile> worldTileMapIterator = worldTileMap.values().iterator(); //collection view of values in the map
		while(worldTileMapIterator.hasNext()) {
			WorldTile worldTile = worldTileMapIterator.next();
			if (!worldTile.shouldStorePos(xPos, yPos, layerWidth, layerHeight)){ //remove if shouldn't keep the pos
				worldTileMapIterator.remove();
			}
		}
		
		int worldFrameRenderCallRate = 2;
		for (int worldTilexPosition = (int)(xPos/WorldTile.worldTileSize) - 2; worldTilexPosition <= (xPos + layerWidth + 2)/WorldTile.worldTileSize; worldTilexPosition++){
			for (int worldTileyPosition = (int)(yPos/WorldTile.worldTileSize) - 2; worldTileyPosition <= (yPos + layerHeight + 2)/WorldTile.worldTileSize; worldTileyPosition++){
				int worldTileHashCode = WorldTile.worldTileHash(worldTilexPosition, worldTileyPosition);
				if (!worldTileMap.containsKey(worldTileHashCode)){
					WorldTile worldTileTemp = createWorldTile(worldTilexPosition, worldTileyPosition);
					worldTileMap.put(worldTileHashCode, worldTileTemp);
					worldFrameRenderCallRate--;
					if (!storedTiles && worldFrameRenderCallRate == 0){
						return;
					}
				}
			}
		}
	}

	public abstract WorldTile createWorldTile(int worldTilexPosition, int worldTileyPosition);
	
}
