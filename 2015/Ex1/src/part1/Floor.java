package part1;


public class Floor {
	int finalFloor = 0;
	char goToUpperFloor = "(".charAt(0);
	char goToLowerFloor = ")".charAt(0);
	int currentFloor;
	
	
	public Floor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public int getFinalFloor (String inputGiven) {
		for(int i = 0; i < inputGiven.length(); i++) {
			if(inputGiven.charAt(i) == goToUpperFloor) {
				finalFloor++;
			}else {
				if (inputGiven.charAt(i) == goToLowerFloor){
					finalFloor--;
				}
			}
		}
		return finalFloor;
	}
	
	public boolean hasEnteredBasement(int currentFloor) {
		if(currentFloor == -1) {
			return true;
		}
		return false;
	}
	
	public int getNextFloor (String inputGiven, int floorsTaken) {
		if(inputGiven.charAt(floorsTaken)==goToUpperFloor) {
			currentFloor++;
		}else {
			if(inputGiven.charAt(floorsTaken)==goToLowerFloor) {
				currentFloor--;
			}
		}
		return currentFloor;
	}
}
