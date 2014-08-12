package tutorials.graph;

public class DirectedGraph {
	
	private int numVertices ; 
	private int[][] edges ; 
	
	private int[] inDegrees ; 
	private int[] outDegrees; 
	
	
	public DirectedGraph(int numVertices)
	{
		this.numVertices = numVertices ; 
		edges = new  int[numVertices][numVertices]; 
		inDegrees = new int[numVertices]; 
		outDegrees = new int[numVertices]; 
	}
	
	
	public void addEdge(int u, int v){
		
		if( u<0 || u>numVertices)
			return  ; 
		if( v<0 || v>numVertices)
			return ; 
		
		edges[u][v]   = 1; 
		outDegrees[u] += 1; 
		inDegrees[v]  += 1; 
	} 
	
	
	
	/**
	 * http://www.graph-magics.com/articles/euler.php 
	 * 
	 * A directed graph is an eulerian circuit if and only if
	 * (1) all vertices with nonzero degree belong to a single 
	 *      strongly connected component. 
	 * (2) each vertex has the same in-degree as out-degree 
	 * 
	 * NOTE that we don't care vertices with zeros degrees as 
	 * they don't belong to Eulerian cucle or path. ( We only
	 * consider all edges) 
	 * 
	 * Time complexity:  O(V + E)  
	 * 
	 * @return
	 */
	public boolean isEulerianCircuit(){
		
		// condition 1: all vertices with nonzero degree are 
		// strongly connected 
		if( !areNonzeroVerticesConnected() )
			return false ;
		
		// condition 2: check the in and out degree 
		for(int i=0; i<numVertices; i++)
			if(inDegrees[i] != outDegrees[i])
				return false ; 		
		return true ; 
	}
	
	
	/**
	 *  Return true if the vertices with nonzero degrees in the graph are 
	 *  strongly connected. Note this is a bit different from telling
	 *  whether a directed graph is strongly connected. A directed graph is 
	 *  strongly connected if there is a path between any two pair of vertices. 
	 * 
	 *  The graph connectivity looks at all vertices, may it be with zero
	 *  or nonzero degrees 
	 *  
	 *  See: 
	 *   http://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
	 *  
	 *  For an undirected graph,  we can just do a BFS or DFS 
	 *  starting from any vertex. If BFS or DFS visits all vertices with 
	 *  nonzero degree then the given undirected graph is connected. 
	 *  
	 *  For a directed graph, we can use Kosaraju’s DFS based simple 
	 *  algorithm that does two DFS traversals of graph:
	 *  
	 *  1) Initialise all vertices as not visited.
	 *  2) Do a DFS traversal of graph starting from any arbitrary vertex v. 
	 *     If DFS traversal doesn’t visit all vertices, then return false.
	 *  3) Reverse all arcs (or find transpose or reverse of graph)
	 *  4) Mark all vertices as not-visited in the reversed graph 
	 *  5) Do a DFS traversal of the reversed graph starting from the same
	 *     vertex v ( same as step 2) 
	 *     If DFS traversal doesn’t visit all vertices, then return false. 
	 *     Otherwise return true.	 
	 *     
	 * Time Complexity: 
	 *   This implementation is same as Depth First Search which is O(|V|+|E|),
	 *   where V is the set of vertices, and E is the set of edges 
	 * 
	 * @return
	 */
	public boolean areNonzeroVerticesConnected(){
		
		boolean[] visited = new boolean[numVertices];
		for(int i=0; i<numVertices; i++)
			visited[i] = false; 
			    
	    // do DFS traversal from the first vertex with nonzero degree
		int v; 
		for(v=0; v<numVertices; v++)
			if(outDegrees[v]>0)
				break ; 
		if(v == numVertices) // no edge found  
			return false; 
		
		DFS(v, visited); 
		for(int i=0; i<numVertices; i++)
			if(outDegrees[i]>0 && !visited[i]) // if DFS cannot traverse all "nonzero" vertices 
				return false ; 
		
		// check the connectivity for the reversed graph 
		for(int i=0; i<numVertices; i++)
			visited[i] = false; 
		
		// do DFS for reversed graph starting from the same vertex. 
		reverseDFS(v, visited);
		
		// If all "nonzero" vertices are not visited in second DFS, then
	    // return false
		for(int i=0; i<numVertices; i++)
			if(outDegrees[i]>0 && !visited[i])
				return false ; 		
		return true ; 
	}


	
	protected void DFS(int v, boolean[] visited){
		visited[v] = true; 
		for(int i=0;  i<numVertices; i++)
			if(edges[v][i]!=0 && !visited[i])
				DFS(i, visited); 
	}
	
	
	protected void reverseDFS(int v, boolean[] visited){
		visited[v] = true; 
		for(int i=0; i<numVertices; i++)
			if(edges[i][v]!=0 && !visited[i])
				reverseDFS(i, visited); 
		
	}
	
}
