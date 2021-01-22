package datastructures.graphs;

import java.util.ArrayList;
import java.util.Hashtable;

public class Graphs {
	int numberOfNodes;
	Hashtable<Integer,ArrayList<Integer>> adjacentList;
	
	public Graphs() {
		numberOfNodes = 0;
		adjacentList = new Hashtable<>();
	}
	
	public void addVertex(Integer vertex) {
		ArrayList<Integer> edgeList = new ArrayList<Integer>();
		adjacentList.put(vertex,edgeList);
		numberOfNodes ++;
	}
	
	public void addEdge(Integer vertex1, Integer vertex2) {
		adjacentList.get(vertex1).add(vertex2);
		adjacentList.get(vertex2).add(vertex1);
	}
	
	public void showConnections() {
		Object[] keys;
		keys = adjacentList.keySet().toArray();
		for(Object key:keys) {
			System.out.println(key+"------>"+adjacentList.get(key));
		}
	}
	
	public static void main(String[] args) {
		Graphs case1 = new Graphs();
		case1.addVertex(1);
		case1.addVertex(2);
		case1.addVertex(3);
		case1.addEdge(1, 2);
		case1.addEdge(3, 2);
		case1.showConnections();
		
		

	}

}
