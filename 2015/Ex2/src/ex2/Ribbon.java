package ex2;

public class Ribbon extends Box{
	
	public int length;
	public int width;
	public int height;
	
	@Override
	public int getSmallestSide(int length, int width, int height) {
		if(length+width < length+height && length+width < width+height) {
			return (length+width)*2;
		}else {
			if(length+height < width + height) {
				return (length+height)*2;
			}
			else {
				return (width + height)*2;
			}
		}
	}
	
	@Override
	public int getDimension(int length, int width, int height) {
		return length*width*height;
	}
	
	
}
