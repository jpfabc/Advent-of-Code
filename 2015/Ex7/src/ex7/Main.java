package ex7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	

	static String execPath = System.getProperty("user.dir")+("\\src\\ex7\\input.txt");
	
	static File fileToRead = new File(execPath);
	
	public static void main(String[] args) throws FileNotFoundException {
		StringInterpreter intrepeter = new StringInterpreter();		
		List<String> singleInput=intrepeter.splitSingleInput(intrepeter.listInput(fileToRead).get(0));
		intrepeter.setWiresValue(singleInput);
		System.out.println(intrepeter.wiresMap);
	}

}
