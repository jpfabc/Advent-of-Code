package part1;

public class Main {

	

	
	public static void main(String[] args) {
		int currentFloor = 0;
		int counter = 0;
		Floor floor= new Floor(currentFloor);
		for(int i = 0; i<args[0].length(); i++) {
			if(floor.hasEnteredBasement(floor.getCurrentFloor()) == false) {
				floor.setCurrentFloor(floor.getNextFloor(args[0], i));
				counter++;
			}
			else {
				break;
			}
		}
		
		System.out.println(counter);
		
	}

}
