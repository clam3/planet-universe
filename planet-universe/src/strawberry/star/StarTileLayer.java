package strawberry.star;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import strawberry.world.WorldTile;
import strawberry.world.WorldTileLayer;

public class StarTileLayer extends WorldTileLayer {
	
	private List<Image> starSprites;
	
	public StarTileLayer(float windowScale, GameContainer gc) {
		super(windowScale, gc);
		this.starSprites = new ArrayList<Image>();
		try {
			this.starSprites.add(new Image("res/sprites/star_1.png"));
			this.starSprites.add(new Image("res/sprites/star_2.png"));
			this.starSprites.add(new Image("res/sprites/star_3.png"));
			this.starSprites.add(new Image("res/sprites/star_4.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public WorldTile createWorldTile(int worldTilexPosition, int worldTileyPosition) {
		StarGridTile starGridTile = new StarGridTile(worldTilexPosition,worldTileyPosition, this);
		return starGridTile;
	}
	
	public int getWorldStarSpriteCount() {
		return starSprites.size();
	}
	
	public Image getStarImage(int index) {
		return starSprites.get(index);
	}

}
