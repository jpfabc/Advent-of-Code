package ex6;


public class Grid {
	
	Integer [][] grid = new Integer [1000][1000];
	Light currentLight = new Light(0, 0, 0);
	
	public Integer [][] initializeGrid () {
		Light newLight = new Light(currentLight.getX(),currentLight.getY(),currentLight.getTurnedOn());
		for(int y = 0; y < 1000; y++) {
			for(int x = 0; x < 1000; x++) {
				newLight.setX(currentLight.getX()+1);
				grid[y][x]=newLight.getTurnedOn();
				currentLight = newLight;
			}
			newLight.setY(currentLight.getY()+1);
			newLight.setX(0);
			currentLight = newLight;
		}
		return grid;
	}
	
	
	public void changeLightBehaviour (int x, int y, int lightValue, String behaviourInput) {
		Light lightToCheck = new Light (x,y,lightValue);
		if(behaviourInput.startsWith("turnoff")) {
			lightToCheck.turnOff(lightToCheck);
			grid[lightToCheck.getX()][lightToCheck.getY()] = lightToCheck.getTurnedOn();
		}else {
			if(behaviourInput.startsWith("turnon")) {
				lightToCheck.turnOn(lightToCheck);
				grid[lightToCheck.getX()][lightToCheck.getY()] = lightToCheck.getTurnedOn();
			}
			else {
				lightToCheck.toggle(lightToCheck);
				grid[lightToCheck.getX()][lightToCheck.getY()] = lightToCheck.getTurnedOn();
			}
		}
	}
	
	public int countTurnedOnLights () {
		int counter = 0 ;
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				counter+=grid[x][y];
			}
		}		
		return counter;
	}
	

}
