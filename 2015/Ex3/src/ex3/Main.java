package ex3;


public class Main {

	public static void main(String[] args) {
		Map santaMap = new Map();
		Map robotMap = new Map();
		for(int i = 0 ; i < args[0].length(); i++) {
			if(i%2 == 0) {
				santaMap.move(args[0].charAt(i));
			}else {
				robotMap.move(args[0].charAt(i));
			}
			
		}
		System.out.println(santaMap.getHousesVisited(robotMap.housePositions));
	}
}
