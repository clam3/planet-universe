package strawberry.star;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import strawberry.nebula.SimplexNebulaGenerationLayer;
import strawberry.world.TileLayer;

public class StarCanvas {
	
	private List<TileLayer> starLayerList;
	
	public StarCanvas(GameContainer gc) {
		this.starLayerList = new ArrayList<TileLayer>();
//		for (int i = 0; i < 18; i++) {
//			this.starLayerList.add(new StarTileLayer(randFloat(0.01f,8.0f) ,gc));
//		}
		
		this.starLayerList.add(new StarTileLayer(0.01f ,gc)); //v far layer
		this.starLayerList.add(new StarTileLayer(0.02f ,gc));
		this.starLayerList.add(new SimplexNebulaGenerationLayer(0.04f, gc));
		this.starLayerList.add(new StarTileLayer(0.03f ,gc));
		this.starLayerList.add(new StarTileLayer(0.12f ,gc));
	}
	
	public void draw(Graphics g, float xPos, float yPos) {
		for (TileLayer starTileLayer : this.starLayerList) {
			starTileLayer.draw(g, xPos, yPos);
		}
	}
	
	public static float randFloat(float min, float max) {
	    Random rand = new Random();
	    float result = rand.nextFloat() * (max - min) + min;
	    return result;
	}
}
