package ex5;

public class Main {

	public static void main(String[] args) {
		StringConverter stringInput = new StringConverter("",0);
		for(int i = 0; i< args.length; i++) {
			stringInput.setInput(args[i]);
			if (stringInput.isNiceString(stringInput.getInput())) {
				stringInput.setCounter(stringInput.getCounter()+1);
			}
		}
		System.out.println(stringInput.getCounter());
		
	}

}
