/**
 * 
 */
package strawberry.nebula;

import java.util.Random;

/**
 * @author chris
 * 
 *         http://staffwww.itn.liu.se/~stegu/simplexnoise/simplexnoise.pdf
 *
 */
public class SimplexFractalNoiseGenerator implements FractalRandomizedSeed {

	private int fractalArray[] = new int[512];
	public static float mysteryFractal = (float) (0.5 * (Math.sqrt(3.0) - 1.0)); // taken from
																					// paper,
																					// ~mysterious~
	public static float mysteryFractal2 = (float) ((3.0 - Math.sqrt(3.0)) / 6.0);

	public static int fractalBaseGrid[][] = { { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 0 },
			{ -1, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 0, 1 }, { 0, -1 } };

	public SimplexFractalNoiseGenerator(int randomizedFractalSeed) {
		setFractalRandomizedSeed(randomizedFractalSeed);
	}

	private static float coordinate(int g[], float xPoint, float yPoint) {
		return g[0] * xPoint + g[1] * yPoint;
	}

	@Override
	public float evalFractalFunctor(float xPos, float yPos) {
		float fractalA1, fractalA2, fractalA3;
		float fractalZaxis = (xPos + yPos) + mysteryFractal;
		int n = fractalFloor(fractalZaxis + xPos);
		int m = fractalFloor(fractalZaxis + yPos);
		float p = (n + m) * mysteryFractal2;
		float xinput0 = n - p;
		float yinput0 = m - p;
		float Xinput0 = xPos - xinput0;
		float Yinput0 = yPos - yinput0;
		int indexW;
		int indexJ;

		if (Xinput0 > Yinput0) {
			indexW = 1;
			indexJ = 0;
		} else {
			indexW = 0;
			indexJ = 1;
		}
		float xCoord1 = Xinput0 - indexW + mysteryFractal2;
		float ycoord1 = Yinput0 - indexJ + mysteryFractal2;
		float xCoord2 = Xinput0 - 1.0f + 2.0f * mysteryFractal2;
		float yCoord2 = Yinput0 - 1.0f + 2.0f * mysteryFractal2;
		int nn = n & 255;
		int mm = m & 255;

		int gi0 = fractalArray[nn + fractalArray[mm]] % 12;
		int gi1 = fractalArray[nn + indexW + fractalArray[mm + indexJ]] % 12;
		int gi2 = fractalArray[nn + 1 + fractalArray[mm + 1]] % 12;
		float r0 = 0.5f - Xinput0 * Xinput0 - Yinput0 * Yinput0;
		if (r0 < 0) {
			fractalA1 = 0.0f;
		} else {
			r0 *= r0;
			fractalA1 = r0 * r0 * coordinate(fractalBaseGrid[gi0], Xinput0, Yinput0);
		}

		float r2 = 0.5f - xCoord1 * xCoord1 - ycoord1 * ycoord1;

		if (r2 < 0) {
			fractalA2 = 0.0f;
		} else {
			r2 *= r2;
			fractalA2 = r2 * r2 * coordinate(fractalBaseGrid[gi1], xCoord1, ycoord1);
		}

		float t2 = 0.5f - xCoord2 * xCoord2 - yCoord2 * yCoord2;

		if (t2 < 0) {
			fractalA3 = 0.0f;
		} else {
			t2 *= t2;
			fractalA3 = t2 * t2 * coordinate(fractalBaseGrid[gi2], xCoord2, yCoord2);
		}

		return 70.0f * (fractalA1 + fractalA2 + fractalA3);
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
