package tutorials.graph;

import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * == Problem == 
 * Given a sorted list of words in an alien's language, output the order of its characters 
 * http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/ 
 * 
 * == Examples == 
 * (1) words[] = {"baa", "abcd", "abca", "cab", "cad"} ==> 'b', 'd', 'a', 'c' 
 * (2) words[] = {"caa", "aaa", "aab"} ==> 'c', 'a', 'b' 
 * 
 * == Analysis == 
 * This core of this problem is a graph topological sorting problem. The hassle is 
 * in creating the graph  
 * 
 * @author jack
 *
 */
public class AlienDict {
	
	public static String getCharOrder(String[] words){
		
		HashMap<Character, Integer> charToId = new HashMap<Character, Integer>(); 
		HashMap<Integer, Character> idToChar = new HashMap<Integer, Character>(); 
		assignIds(words, charToId, idToChar); 

		int numNodes = idToChar.keySet().size(); 
		int[][] graph = new int[numNodes][numNodes]; 
		constructGraph(words, charToId, graph);
		return getCharOrder(graph, idToChar); 
	}
	
	
	public static void assignIds(String[] words, HashMap<Character, Integer> charToId, 
			HashMap<Integer, Character> idToChar){
		
		int id = 0; 
		for(String word: words)
			for(int i=0;  i<word.length(); i++){
				char c = word.charAt(i); 
				if(!charToId.keySet().contains(c)){
					charToId.put(c, id); 
					idToChar.put(id, c); 
					id++; 
				}
			}
	}
	
	public static void constructGraph(String[] words, 
			HashMap<Character, Integer> charToId, int[][] graph){
		
		int numWords = words.length; 
		for(int i=0; i<numWords; i++)
			for(int j=i+1; j<numWords; j++)				
				addEdge(words[i],words[j], charToId, graph); 
	}
	
	
	/**
	 *  If a is lexicographically smaller than b, then we add 
	 *  one edge from a to b (a->b) 
	 * 
	 * @param first
	 * @param second
	 * @param graph
	 */
	protected static void addEdge(String first, String second, 
			HashMap<Character, Integer> charToId, int[][] graph){
	
		int len = Math.min(first.length(), second.length()); 
		for(int i=0; i<len; i++)
		{
			if(first.charAt(i)!=second.charAt(i)){
				int headId = charToId.get(first.charAt(i)); 
				int tailId = charToId.get(second.charAt(i)); 
				graph[headId][tailId] = 1; 
				break; 
			}
		}
	}
	
	
	protected static String getCharOrder(int[][] graph, HashMap<Integer, Character> idToChar){
		
		Stack<Integer> vertexes = new Stack<Integer>();
		topologicalSort(graph, vertexes); 
		
		StringBuilder builder = new StringBuilder();
		while(!vertexes.isEmpty()){
			builder.append( idToChar.get(vertexes.pop())); 
		}
		return builder.toString(); 
	}

	
	/**
	 *  The topological sort of a graph 
	 *  Time complexity: O(|V| + |E|), where |V| is #vertexes and |E| is the 
	 *                   #edges 
	 * 
	 * @param graph
	 * @param vertexes
	 */
	protected static void topologicalSort(int[][] graph, Stack<Integer> vertexes){
		
		int numVertexes = graph.length ; 
		boolean[] visited = new boolean[numVertexes];  
		for(int i=0;  i<numVertexes;  i++)
			visited[i] = false; 
		
		for(int v=0; v<numVertexes; v++)
			if(!visited[v])
				topologicalSort(graph, v, visited, vertexes); 
	}
	
	
	protected static void topologicalSort(int[][] graph, int currVertex, boolean[] visited, 
			Stack<Integer> vertexes){
		
		visited[currVertex] = true ; 
		for(int v=0;  v<graph.length; v++){
			if(graph[currVertex][v]!=0 && !visited[v])
				topologicalSort(graph, v, visited, vertexes); 
		}
		vertexes.push(currVertex); 
	}
}
