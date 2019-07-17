/**
 * 
 */
package strawberry.util;

/**
 * @author chris
 *
 */
public class TrigUtil {
	public static float radians2degrees = (float) (Math.PI / 180.0);
	public static float degrees2radians = (float) (180/Math.PI);
	
	public static float getMedian(float imgBufferVal, float minVal, float maxVal) {
		if (imgBufferVal < minVal) {
			return minVal;
		} else if (imgBufferVal > maxVal) {
			return maxVal;
		} else {
			return imgBufferVal;
		}
	}
	
}
