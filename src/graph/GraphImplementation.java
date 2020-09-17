package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImplementation {

	int noOfNodes;
	Map<Integer, List<Integer>> adjacencyListMap;
	
	GraphImplementation(){
		this.noOfNodes = 0;
		this.adjacencyListMap = new HashMap<>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphImplementation graphImplementation = new GraphImplementation();
		graphImplementation.addVertex(1);
		graphImplementation.addVertex(2);
		graphImplementation.addVertex(3);
		graphImplementation.addVertex(4);
		graphImplementation.addEdge(1,2);
		graphImplementation.addEdge(1,3);
		graphImplementation.addEdge(2,3);
		graphImplementation.addEdge(3,4);
		graphImplementation.showConnections();
		
	}

	//Vertex and Node are same
	private void addVertex(int node) {
		adjacencyListMap.put(node, new ArrayList<Integer>());
		this.noOfNodes++;
	}

	private void addEdge(int node1, int node2) {
		// add both ways as it is an undorected graph
		adjacencyListMap.get(node1).add(node2);
		adjacencyListMap.get(node2).add(node1);
	}
	
	private void showConnections() {
		adjacencyListMap.entrySet().stream().forEach(entrySet -> {
			System.out.println(entrySet.getKey() +" --> "+entrySet.getValue().toString());
		});
		
	}
}
