package datastructures.hashtables;
 
public class KeyValue {
	private String key;
	private int value;
	
	public KeyValue(String key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public int getValue() {
		return this.value;
	}
}