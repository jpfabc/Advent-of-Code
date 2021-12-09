package ex2;

public class Main {

	
	
	public static void main(String[] args) {
		int totalWrappingPaperNeeded = 0;
		Ribbon ribbon = new Ribbon();
		for (int i = 0; i<args.length; i++) {
			ribbon.convertInput(args[i]);
			totalWrappingPaperNeeded += ribbon.getNeededWrappingPaper();
		}
		
		System.out.println(totalWrappingPaperNeeded);
	}

}