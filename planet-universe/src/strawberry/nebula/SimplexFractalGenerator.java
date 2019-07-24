/**
 * 
 */
package strawberry.nebula;

/**
 * @author chris
 *
 * https://en.wikipedia.org/wiki/Fractal_landscape
 */
public class SimplexFractalGenerator implements FractalRandomizedSeed {
	
	public int fractalOctave;
	public float fractalOpacity;
	public FractalRandomizedSeed randFractal;
	
	public SimplexFractalGenerator(SimplexFractalNoiseGenerator simplexFractalNoiseGenerator, int fractalOctave, float fractalOpacity) {
		System.out.println("i liek trains");
		this.randFractal = simplexFractalNoiseGenerator;
		this.fractalOctave = fractalOctave;
		this.fractalOpacity = fractalOpacity;
		
	}

	/**
	 * this makes me cri
	 * https://jbum.com/pixmagic/gallogic.html
	 * 
	 * https://malisper.me/generating-fractals-with-postgres-escape-time-fractals/
	 * ctrl+f for bitwise 
	 * 
	 * http://datastructur.es/sp17/materials/lab/lab14/lab14.html#generating-a-fractal-sound-using-bitwise-operations
	 */
	@Override
	public float evalFractalFunctor(float xPos, float yPos) {
		float fractalSum = 0;
		float fractalWeight = 1.0f;
		for (int i = 0; i < this.fractalOctave; i++) {
			fractalSum += fractalWeight + this.randFractal.evalFractalFunctor(xPos * (1<<i), yPos * (1<<i)); //bit-wise operation
			fractalWeight = fractalWeight * fractalOpacity;
		}
		return fractalSum;
		
	}
	
	@Override
	public void setFractalRandomizedSeed(int randomizedFractalSeed) {
		// TODO Auto-generated method stub
		this.randFractal.setFractalRandomizedSeed(randomizedFractalSeed);
	}

}
