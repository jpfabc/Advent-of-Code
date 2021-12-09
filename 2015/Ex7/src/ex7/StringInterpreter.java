package ex7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StringInterpreter {

	public HashMap<Wire, Boolean> wiresMap = new HashMap<Wire, Boolean>();
	List<String> splittedInput = new ArrayList<String>();
	

	public StringInterpreter (){
	}
	
	public static boolean isInteger(String s) {
	    return checkIfInteger(s,10);
	}
	
	public static boolean checkIfInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
	
	
	
	public List<String> listInput (File fileToRead) throws FileNotFoundException{
		List<String> inputScan = new ArrayList<String>();
		Scanner scanner = new Scanner (fileToRead);
		while (scanner.hasNextLine()) {
			inputScan.add(scanner.nextLine());			
		}
		scanner.close();
		return inputScan;
	}
	
	public List<String> splitSingleInput (String input) {
		String[] tempStringArray= input.split(" ");
		for (int i = 0; i < tempStringArray.length; i++) {
			splittedInput.add(tempStringArray[i]);
		
		}
		Wire wire = new Wire(splittedInput.get(splittedInput.size()-1));
		wiresMap.put(wire, false);
		return splittedInput;
	}
	
	
	public boolean checkIfThereAreNoDependencies(List<String> splittedInput) {
		Wire wireToCheckA = new Wire (splittedInput.get(2));
		if(splittedInput.size() == 3 || wireToCheckA.isConnected()) {
			return true;
		} else if (splittedInput.size() == 4) {
			if(isInteger(splittedInput.get(1))) {
				return true;
			}
			Wire wireToCheck = new Wire (splittedInput.get(1));
			if(wireToCheck.isConnected()) {
				return true;
			}
			else {
				return false;
			}
		} else if (splittedInput.size() == 5) {
			if(isInteger(splittedInput.get(0)) && isInteger(splittedInput.get(2))) {
				return true;
			}
			Wire wireToCheckB= new Wire (splittedInput.get(2));
			if(isInteger(splittedInput.get(0)) && wireToCheckA.isConnected()) {
				return true;
			}
			else if(isInteger(splittedInput.get(2)) && wireToCheckB.isConnected()) {
					return true;
				
			}
			else if(wireToCheckA.isConnected() && wireToCheckB.isConnected()) {
					return true;
				}
		
		}
		return false;
	}
	
	
	public void setWiresValue(List<String> splittedInput) {
		if(!checkIfThereAreNoDependencies(splittedInput)){
			return;
		}else {
				if(splittedInput.size() == 3 ) {
					Wire wireToSetValue= new Wire(splittedInput.get(2));
					if(isInteger(splittedInput.get(0))) {
						wireToSetValue.setSignal(Integer.parseInt(splittedInput.get(0)));
						wiresMap.put(wireToSetValue, true);
					}
				}
		}
	}
	
}
