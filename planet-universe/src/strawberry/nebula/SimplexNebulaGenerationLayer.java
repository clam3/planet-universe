/**
 * 
 */
package strawberry.nebula;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;

import strawberry.world.WorldTile;
import strawberry.world.WorldTileLayer;

/**
 * @author chris
 *
 * http://slick.ninjacave.com/javadoc/org/newdawn/slick/ImageBuffer.html
 */
public class SimplexNebulaGenerationLayer extends WorldTileLayer {

	public FractalFunctor fractalFunctor;
	public ImageBuffer simplexNoiseGradientBuffer;
	private int[][] simplexNoiseColorPalette;
	
	/**
	 * @param windowScale
	 * @param gc
	 */
	public SimplexNebulaGenerationLayer(float windowScale, GameContainer gc) {
		super(windowScale, gc);
		simplexNoiseGradientBuffer = new ImageBuffer(WorldTile.worldTileSize, WorldTile.worldTileSize);
		try {
			Image nebulaGrad = new Image("res/gradients/purple.png");
			simplexNoiseColorPalette = new int[nebulaGrad.getWidth()][nebulaGrad.getHeight()];
			for (int i = 0; i < simplexNoiseColorPalette.length; i++) {
				Color gradientColor = nebulaGrad.getColor(i, 0);
				simplexNoiseColorPalette[i][0] = gradientColor.getRedByte();
				simplexNoiseColorPalette[i][1] = gradientColor.getGreenByte();
				simplexNoiseColorPalette[i][2] = gradientColor.getBlueByte();
				
			}
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Override
	public WorldTile createWorldTile(int worldTilexPosition, int worldTileyPosition) {
		// TODO Auto-generated method stub
		return null;
	}

}
