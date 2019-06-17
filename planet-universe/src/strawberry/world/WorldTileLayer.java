package strawberry.world;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class WorldTileLayer extends TileLayer {
	
	private Map<Integer, WorldTile> worldTileMap;
	
	public WorldTileLayer(float windowScale, GameContainer gc) {
		super(windowScale, gc);
		this.worldTileMap = new HashMap<Integer, WorldTile>();
		
	}

	@Override
	public void draw(Graphics g, float xPos, float yPos) {
		
		
	}
	
	private void update(float xPos, float yPos, boolean storedTiles) {
		
	}
}
