package ex2;

public class Box {

	public int length;
	public int width;
	public int height;
	

	public void convertInput (String inputGiven) {
		String[] inputSplit = inputGiven.split("x");
		length = Integer.parseInt(inputSplit[0]);
		width = Integer.parseInt(inputSplit[1]);
		height = Integer.parseInt(inputSplit[2]);		
	}
	
	public int getDimension (int length, int width, int height) {
		return (2*length*width)+(2*width*height)+(2*height*length);
	}
	
	public int getSmallestSide(int length, int width, int height) {
		if(length*width < length*height && length*width < width*height) {
			return length*width;
		}else {
			if(length*height < width * height) {
				return length*height;
			}
			else {
				return width * height;
			}
		}
	}
	
	public int getNeededWrappingPaper () {
		return getDimension(length, width, height)+getSmallestSide(length, width, height);
	}

}
