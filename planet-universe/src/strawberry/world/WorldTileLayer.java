package strawberry.world;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class WorldTileLayer extends TileLayer {
	
	private Map<Integer, WorldTile> worldTileMap;
	private int frameTileRenderRate = 10; // arbitary, u pick 
	
	public WorldTileLayer(float windowScale, GameContainer gc) {
		super(windowScale, gc);
		this.worldTileMap = new HashMap<Integer, WorldTile>();
		
	}

	@Override
	public void draw(Graphics g, float xPos, float yPos) {
		
		
	}
	
	private void update(float xPos, float yPos, boolean storedTiles) {
		Iterator<WorldTile> worldTileMapIterator = worldTileMap.values().iterator();
		while(worldTileMapIterator.hasNext())
		{
			WorldTile worldTile = worldTileMapIterator.next();
			if (!worldTile.shouldStorePos(xPos, yPos, layerWidth, layerHeight)){
				worldTileMapIterator.remove();
				if (worldTileMap.containsKey(worldTile.hashCode())){
					throw new IllegalStateException();
				}
			}
		}
		int worldFrameRenderCallRate = 2;
		for(int worldTilexPosition = (int)(xPos/WorldTile.worldTileSize)-2; worldTilexPosition <= (xPos + layerWidth + 2)/WorldTile.worldTileSize; worldTilexPosition++){
			for(int worldTileyPosition = (int)(yPos/WorldTile.worldTileSize)-2; worldTileyPosition <= (yPos + layerHeight + 2)/WorldTile.worldTileSize; worldTileyPosition++){
				int worldTileHashCode = WorldTile.worldTileHash(worldTilexPosition, worldTileyPosition);
				if (!worldTileMap.containsKey(worldTileHashCode)){
					WorldTile worldTileTemp = createWorldTile(worldTilexPosition,worldTileyPosition);
					worldTileMap.put(worldTileHashCode, worldTileTemp);
					worldFrameRenderCallRate--;
					if (!storedTiles && worldFrameRenderCallRate == 0){
						return;
					}
				}
			}
}
	}

	private WorldTile createWorldTile(int worldTilexPosition, int worldTileyPosition) {
		// TODO Auto-generated method stub
		return null;
	}
}
