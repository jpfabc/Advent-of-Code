package ex7;

public class Operators {

	public int getANDOperationResult (int firstValue, int lastValue) {
		return firstValue & lastValue;
	}
	
	public int getOROperationResult (int firstValue, int lastValue) {
		return firstValue | lastValue;
	}
	
	public int getComplementOperationResult (int value) {
		return ~value;
	}
	
	public int getLSHIFTOperationResult (int value, int quantityToShift) {
		return value << quantityToShift;
	}
	
	public int getRSHIFTOperationResult (int value, int quantityToShift) {
		return value >> quantityToShift;
	}
	
	
}
