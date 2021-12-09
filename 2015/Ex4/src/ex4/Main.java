package ex4;

import java.security.NoSuchAlgorithmException;

public class Main {

	
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Converter stringToConvert = new Converter (args[0],0);
		while(stringToConvert.verifyMD5Hash(stringToConvert.input) != true) {
			stringToConvert.incrementCounterToString();
		}
		System.out.println(stringToConvert.getCounter());
	}

}
