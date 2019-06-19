package strawberry.star;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Graphics;

import strawberry.world.WorldTile;

public class StarGridTile extends WorldTile{
	
	private static Random rand = new Random();
	private List<Star> starList;
	
	
	public StarGridTile(int xPos, int yPos, StarTileLayer starTileLayer) {
		super(xPos, yPos);
		rand.setSeed(worldTileHash(xPos, yPos) + starTileLayer.hashCode());
		int test = rand.nextInt(3);
		starList = new ArrayList<Star>(test); // 4 images
		int starSpriteTypes = starTileLayer.getWorldStarSpriteCount();
		for (int i = 0; i < test; i++) {
			starList.add(i, new Star((xPos + rand.nextFloat()) * WorldTile.worldTileSize, (yPos + rand.nextFloat()) * WorldTile.worldTileSize, 
					starTileLayer.getStarImage(rand.nextInt(starSpriteTypes))));
		}
		//System.out.println("Oink");
	}


	@Override
	public void drawWorldTile(Graphics g) {
		// TODO Auto-generated method stub
		for (Star star : starList) {
			star.draw(g);
		}
		
	}

	
	
	
}
