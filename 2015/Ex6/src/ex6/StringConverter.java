package ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConverter {
	
	
	String input;
	
	public StringConverter (String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	public List<Integer> convertInput(String input) {
		List<Integer> coordinates = new ArrayList<Integer>();
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher regex = pattern.matcher(input);
		while(regex.find()) {
			coordinates.add(Integer.parseInt(regex.group()));
		}
		return coordinates;
	}
	
	public List<Integer> getFirstCoordinate (String input){
		List<Integer> allCoordinates = convertInput(input);
		List<Integer> firstCoordinate = new ArrayList<Integer>();
		firstCoordinate.add(allCoordinates.get(0));
		firstCoordinate.add(allCoordinates.get(1));
		return firstCoordinate;
	}
	
	public List<Integer> getLastCoordinate (String input){
		List<Integer> allCoordinates = convertInput(input);
		List<Integer> lastCoordinate = new ArrayList<Integer>();
		lastCoordinate.add(allCoordinates.get(2));
		lastCoordinate.add(allCoordinates.get(3));
		return lastCoordinate;
	}
}
