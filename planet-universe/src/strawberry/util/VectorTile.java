package strawberry.util;

/**
 * Stores the position of an object. Lets you do things to it.
 *
 */
public class VectorTile {
	
	private float xTilePos;
	private float yTilePos;
	
	public VectorTile(float x, float y) {
		this.xTilePos = x;
		this.yTilePos = y;
	}
	
	public float getIntersectionPoint(VectorTile vt) {
		float floatDistance = this.xTilePos * vt.getyTilePos() - this.yTilePos * vt.getxTilePos(); //intersection; get distance between two points
		return floatDistance;
	}
	
	public void rotate(float rotationalAngle) {
		float cosRotation = (float) Math.cos(rotationalAngle);
		float sinRotation = (float) Math.sin(rotationalAngle);
		float tempXPos = this.xTilePos;
		this.xTilePos = cosRotation * this.xTilePos - sinRotation * this.yTilePos;
		this.yTilePos = sinRotation * tempXPos + cosRotation * this.yTilePos;
		// let's u rotate a point based on the angle you want
 	}
	
	public float getCenter(VectorTile vt) {
		float centerPoint = this.xTilePos * vt.getxTilePos() + this.yTilePos * vt.getyTilePos(); 
		return centerPoint;
	}
	
	public void addDistance(float x, float y) {
		this.xTilePos = this.xTilePos + x;
		this.yTilePos = this.yTilePos + y;
	}
	
	public void subDistance(float x, float y) {
		this.xTilePos = this.xTilePos - x;
		this.yTilePos = this.yTilePos - y;
	}
	
	public void scaleVector(float scaleFactor) {
		this.xTilePos = this.xTilePos * scaleFactor;
		this.yTilePos = this.yTilePos * scaleFactor;
	}
	
	public float getVectorDist() {
		float distance = (float) Math.sqrt(this.xTilePos * this.xTilePos + this.yTilePos * this.yTilePos);
		return distance;
	}
	
	public void normalizedScale() {
		scaleVector(1 / this.getVectorDist());
	}
	
	public float getxTilePos() {
		return xTilePos;
	}
	public void setxTilePos(float xTilePos) {
		this.xTilePos = xTilePos;
	}
	public float getyTilePos() {
		return yTilePos;
	}
	public void setyTilePos(float yTilePos) {
		this.yTilePos = yTilePos;
	}
	
	
}
