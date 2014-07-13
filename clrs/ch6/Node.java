package clrs.ch6;

/** the tree node class */
public class Node<T extends Comparable<? super T>>{
	Node<T> left, right ; 
	T data ; 
	public Node(T data){ this.data = data; } 
}