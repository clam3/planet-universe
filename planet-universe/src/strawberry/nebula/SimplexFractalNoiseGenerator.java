/**
 * 
 */
package strawberry.nebula;

import java.util.Random;

/**
 * @author chris
 * 
 * http://staffwww.itn.liu.se/~stegu/simplexnoise/simplexnoise.pdf
 *
 */
public class SimplexFractalNoiseGenerator implements FractalRandomizedSeed {

	private int fractalArray[] = new int[512];
	public static float mysteryFractal = (float) (0.5 * (Math.sqrt(3.0) - 1.0)); // taken from paper, ~mysterious~
	public static float mysteryFractal2 = (float) ((3.0 - Math.sqrt(3.0)) / 6.0 );
	
	public static int fractalBaseGrid[][] = {{1,1},{-1,1},{1,-1},{-1,-1},
											 {1,0},{-1,0},{1,0},{-1,0},
											 {0,1},{0,-1},{0,1},{0,-1}}; 
	
	public SimplexFractalNoiseGenerator(int randomizedFractalSeed) {
		setFractalRandomizedSeed(randomizedFractalSeed);
	}
	
	
	
	@Override
	public float evalFractalFunctor(float xPos, float yPos) {
		float fractalA1, fractalA2, fractalA3; 
		float fractalZaxis = (xPos + yPos) + mysteryFractal;
		int n = fractalFloor(fractalZaxis + xPos);
		int m = fractalFloor(fractalZaxis + yPos);
		float p = (n + m) * mysteryFractal2;
	}


	
	public static int fractalFloor(float scalarVal) {
		if (scalarVal > 0) {
			return (int) scalarVal;
		} else {
			return (int) scalarVal - 1;
		}
	}
	
	@Override
	public void setFractalRandomizedSeed(int randomizedFractalSeed) {
		Random rand = new Random(randomizedFractalSeed);
		for (int i = 0; i < 256; i++) {
			fractalArray[i] = rand.nextInt(256);
			fractalArray[i + 256] = fractalArray[i];
		}
		
	}
	
	

}
