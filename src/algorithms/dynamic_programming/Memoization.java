package algorithms.dynamic_programming;

import java.util.HashMap;

public class Memoization {
	
	// This is an example where dynamic programming(cache) is not used which turns out to be very inefficient
    public int addTo80(int n) {
        System.out.println("long time");
        return n + 80;
    }

    
    // This is an example where cache is used to save up time 
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int memoizeAddTo80(int n) {
    	if(!cache.containsKey(n)) {
    		System.out.println("long time");
    		cache.put(n, n+80);
    	}
    	return cache.get(n);
    }

    public static void main(String[] args) {
        Memoization memo = new Memoization();
        System.out.println("addTo80: " + memo.addTo80(5));
        System.out.println("addTo80: " + memo.addTo80(5));

        System.out.println("memoizeAddTo80: " + memo.memoizeAddTo80(5));
        System.out.println("memoizeAddTo80: " + memo.memoizeAddTo80(5));
        System.out.println("memoizeAddTo80: " + memo.memoizeAddTo80(5));
        
    }
}
