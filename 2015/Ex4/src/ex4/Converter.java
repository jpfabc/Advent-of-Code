package ex4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Converter {
	
	public String input;
	int counter = 0;
	
	public Converter (String input, int counter){
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

	public String getConversionOutput (String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(input.getBytes());
		BigInteger no = new BigInteger(1, digest); 
		String hashtext = no.toString(16); 
		while (hashtext.length() < 32) { 
            hashtext = "0" + hashtext; 
        } 
		return hashtext;
	}
	
	public boolean verifyMD5Hash (String input) throws NoSuchAlgorithmException {
		String stringConverted = getConversionOutput(input+getCounter());
		if(stringConverted.startsWith("000000")) {
			return true;
		}		
		return false;
	}

	public String incrementCounterToString () {
		setCounter(counter+1);
		return getInput()+getCounter();
	}


	
}
