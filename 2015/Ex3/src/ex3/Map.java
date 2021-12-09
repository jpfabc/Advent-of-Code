package ex3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Map {

	HashMap <Coordinate, Integer> housePositions = new HashMap<Coordinate, Integer>();
	
	private char up = "^".charAt(0);
	private char down = "v".charAt(0);
	private char left = "<".charAt(0);
	private char right = ">".charAt(0);
	Coordinate currentCoordinate = new Coordinate (0,0);
	
	public void move(char nextChar) {
		Coordinate newCoordinate = new Coordinate (currentCoordinate.getX(),currentCoordinate.getY());
		if (nextChar == up) {
			newCoordinate.setY(newCoordinate.getY()+1);
			housePositions.put(newCoordinate,1);
			currentCoordinate = newCoordinate;
		}else if (nextChar == down) {
			newCoordinate.setY(newCoordinate.getY()-1);
			housePositions.put(newCoordinate,1);
			currentCoordinate = newCoordinate;
		}
		else if (nextChar == right) {
			newCoordinate.setX(newCoordinate.getX()+1);
			housePositions.put(newCoordinate,1);
			currentCoordinate = newCoordinate;
		
		}else {
			if(nextChar == left) {
				newCoordinate.setX(newCoordinate.getX()-1);
				housePositions.put(newCoordinate,1);
				currentCoordinate = newCoordinate;
			}
		}		
	}
	
	public HashMap <Coordinate, Integer> getHousePositions(){
		return housePositions;
	}
	
	public int getHousesVisited(HashMap <Coordinate, Integer> mapToCompare){
		Set<Coordinate> keysInMainMap = new HashSet<Coordinate>(housePositions.keySet());
		Set<Coordinate> keysInInputMap = new HashSet<Coordinate>(mapToCompare.keySet());
		
		Set<Coordinate> inMainMapAndNotInInput = new HashSet<Coordinate>(keysInMainMap);
		inMainMapAndNotInInput.removeAll(keysInInputMap); //removes keys that are in the input map that also are in the Main map
		
		Set<Coordinate> inInputMapAndNotInMain = new HashSet<Coordinate>(keysInInputMap);
		inInputMapAndNotInMain.removeAll(keysInMainMap); //removes keys that are in the main map that also are in the input map
		
		Set <Coordinate> inBothMaps = new HashSet<Coordinate>(keysInMainMap);
		inBothMaps.retainAll(keysInInputMap); //retains all similar keys
		
		return inMainMapAndNotInInput.size()+inInputMapAndNotInMain.size()+inBothMaps.size();
	}
}
