/**
 * 
 */
package strawberry.nebula;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ImageBuffer;

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
		simplexNoiseGradientBuffer = new ImageBuffer(256, 4);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public WorldTile createWorldTile(int worldTilexPosition, int worldTileyPosition) {
		// TODO Auto-generated method stub
		return null;
	}

}
