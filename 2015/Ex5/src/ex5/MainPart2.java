package ex5;

public class MainPart2 {

	public static void main(String[] args) {
		NewRules stringInput = new NewRules("",0);
		for(int i = 0; i< args.length; i++) {
			stringInput.setInput(args[i]);
			if (stringInput.isNiceString(stringInput.getInput())) {
				stringInput.setCounter(stringInput.getCounter()+1);
			}
		}
		System.out.println(stringInput.getCounter());
	}

}
