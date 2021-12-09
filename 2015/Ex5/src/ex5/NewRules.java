package ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewRules extends StringConverter{


	public NewRules(String input, int counter) {
		super(input, counter);
	}
	
	@Override
	public boolean obeysFirstRule(String input) {
		List<String> splitedString = splitString(input);
		for(int i = 0; i<splitedString.size(); i++) {
			int counter = 0;
			Pattern pattern = Pattern.compile(splitedString.get(i));
			Matcher matcher = pattern.matcher(input);
			while(matcher.find()) {
				counter++;
				if (counter > 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean obeysSecondRule(String input) {
		for(int i = 0; i < input.length()-2; i++) {
			if(input.charAt(i) == input.charAt(i+2)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean isNiceString(String input) {
		if(obeysFirstRule(input) && obeysSecondRule(input)) {
			return true;
		}
		return false;
	}
	
	private List<String> splitString(String input) {
		List<String> stringSplittedInPairs = new ArrayList<String>() ;
		for (int i = 0; i < input.length()-1; i++) {
			stringSplittedInPairs.add(input.substring(i, i+2));
		}
		return stringSplittedInPairs;
	}

	
}
