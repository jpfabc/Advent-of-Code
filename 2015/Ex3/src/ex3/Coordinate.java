package ex3;

public class Coordinate {

	
	public int x;
	public int y;
	
	public Coordinate (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
    public int hashCode() {  
	        return ((x + y)*(x + y + 1)/2) + y;
    }
	
	@Override
	public boolean equals (Object otherCoordinate) {
		if (otherCoordinate instanceof Coordinate) {
			Coordinate other = (Coordinate) otherCoordinate;
			return this.x == other.getX() && this.y == other.getY();
		}
		return false;
	}
}
