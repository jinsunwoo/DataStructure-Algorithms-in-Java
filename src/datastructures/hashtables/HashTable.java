package datastructures.hashtables;

import java.util.ArrayList; 

/*
 * Outer basket type : array
 * Inner basket type : ArrayList with its elements having type of custom object KeyValue
 * KeyValue object is declared in KeyValue.java *CUSTOM*
 * */
 
public class HashTable {
	
	private ArrayList<KeyValue>[] hashtable;
	private int hashSize;
	
	public HashTable(int size) {
		this.hashtable = new ArrayList[size];
		this.hashSize = size;
	}
	
	// This function will turn key into address which is within the size of hashtable
	public int hashFunction(String key) {
		int hash = 0;
		for(int i=0;i<key.length();i++) {
			hash = (hash +  (int)key.charAt(i))% hashSize;
		}
		return hash;
	}
	
	// This function sets given key and value to hash table
	public void set(String key, int value) {
		int address = this.hashFunction(key);
		if(this.hashtable[address]==null) {
			ArrayList<KeyValue> innerBasket = new ArrayList<KeyValue>();
			this.hashtable[address] = innerBasket;
		}
		KeyValue pair = new KeyValue(key, value);
		this.hashtable[address].add(pair);
	}
	
	// This function returns the value of the given key from the hash table
	public int get(String key) {
		int address = this.hashFunction(key);
		if(this.hashtable[address]==null) {
			return -1;
		} else {
			for(int i=0;i<this.hashtable[address].size();i++) {
				if (this.hashtable[address].get(i).getKey()==key) {
					return this.hashtable[address].get(i).getValue();
				}  
			}
		}
		return -1;
	}
	
	// This function returns an arraylist with all the keys from the hash table
	public ArrayList<String> keys() {
		ArrayList<String> keyLists = new ArrayList();
		for(int i=0;i<this.hashSize;i++) {
			if(this.hashtable[i]!=null) {
				for(int j=0;j<this.hashtable[i].size();j++) {
					 keyLists.add(this.hashtable[i].get(j).getKey());
				}
			}
		}
		return keyLists;
	}

	
	public static void main(String[] args) {
		HashTable case1 = new HashTable(10);
		case1.set("car1", 123);
		case1.set("car2", 234);
		System.out.println(case1.get("car2"));
		System.out.println(case1.keys());
	}
}
