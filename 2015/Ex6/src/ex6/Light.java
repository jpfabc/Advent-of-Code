package ex6;

public class Light {

	private int x;
	private int y;
	private int turnedOn = 0;
	
	public Light (int x, int y, int turnedOn) {
		this.x = x;
		this.y = y;
		this.turnedOn = turnedOn;
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

	public int getTurnedOn() {
		return turnedOn;
	}

	public void setTurnedOn(int turnedOn) {
		this.turnedOn = turnedOn;
	}
	
	public void toggle (Light lightToChange) {
		lightToChange.setTurnedOn(lightToChange.getTurnedOn()+2);
	}
	
	public void turnOn (Light lightToTurnOn) {
		lightToTurnOn.setTurnedOn(lightToTurnOn.getTurnedOn()+1);
	}
	
	public void turnOff (Light lightToTurnOff) {
		if(lightToTurnOff.getTurnedOn()>0) {
			lightToTurnOff.setTurnedOn(getTurnedOn()-1);
		}
	}
}
