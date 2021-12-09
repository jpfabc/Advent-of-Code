package ex5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConverter {
	
	String input;
	int counter;
	
	public StringConverter (String input, int counter){
		this.input = input;
		this.counter = counter;
	}

	

	public String getInput() {
		return input;
	}



	public void setInput(String input) {
		this.input = input;
	}



	public int getCounter() {
		return counter;
	}



	public void setCounter(int counter) {
		this.counter = counter;
	}



	public boolean obeysFirstRule(String input) {
		String inputSubstring=input.replaceAll("[^aeiou]", "");
		if(inputSubstring.length()>=3) {
			return true;
		}
		return false;
	}
	
	public boolean obeysSecondRule (String input) {
		for (int i = 0; i<input.length()-1; i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean obeysThirdRule (String input) {
		Pattern pattern = Pattern.compile("(ab)|(cd)|(pq)|(xy)");
		Matcher regex = pattern.matcher(input);
		if(regex.find()) {
			return false;
		}
		return true;
	}
	
	public boolean isNiceString (String input) {
		if(obeysFirstRule(input) && obeysSecondRule(input) && obeysThirdRule(input)) {
			return true;
		}
		return false;
	}
}
