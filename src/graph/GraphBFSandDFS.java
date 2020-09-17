package graph;

//Java program to print BFS traversal from a given source vertex. 
//BFS(int vertex) traverses vertices reachable from vertex. 
import java.util.*;

//This class represents a directed graph using adjacency list 
//representation 
class GraphBFSandDFS {
	private int noOfVertices; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists ---> here instead of array of list, we can also use
										// map<int/str,list<int>> if we want to have random numbers or strings as
										// vertices

	// Constructor
	GraphBFSandDFS(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		this.adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int vertex1, int vertex2) {
		adj[vertex1].add(vertex2); // as this is directed graph, we are not adding vertex2 to vertex1 again
	}

	// Time Complexity: O(V+E) where V is number of vertices in the graph and E is
	// number of edges in the graph.
	// prints BFS traversal from a given source s
	void BFS(int vertex) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[noOfVertices];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[vertex] = true;
		queue.add(vertex);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			vertex = queue.poll();
			System.out.print(vertex + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			adj[vertex].stream().filter(adjVertex -> !visited[adjVertex]).forEach(adjVertex -> {
				visited[adjVertex] = true;
				queue.add(adjVertex);
			});
		}
	}

//Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
	void DFS(int vertex, boolean[] visited) {
		// Mark all the vertices as not visited(By default
		// set as false)
//		if (visited[vertex]) {
//			return;
//		}
		visited[vertex] = true;
		System.out.print(vertex + " ");
//		for (int adjVertex : adj[vertex]) {
//			if (!visited[adjVertex]) {
//				DFS(adjVertex, visited);
//			}
//		}
		adj[vertex].stream().filter(adjVertex -> !visited[adjVertex]).forEach(adjVertex -> {
			DFS(adjVertex, visited);
		});
	}

	// Driver method to
	public static void main(String args[]) {
		int noOfVertices = 4;
		GraphBFSandDFS g = new GraphBFSandDFS(noOfVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.BFS(2);

		System.out.println("\nFollowing is Depth First Traversal " + "(starting from vertex 2)");
		boolean visited[] = new boolean[noOfVertices];
		g.DFS(2, visited);
	}
}
