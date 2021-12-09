package ex7;

public class Wire {

	public String name;
	public int signal;
	public boolean isConnected;
	
	public Wire (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSignal() {
		return signal;
	}
	
	public void setSignal(int signal) {
		this.signal = signal;
	}
	
	public boolean isConnected() {
		return isConnected;
	}
	
	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
}
