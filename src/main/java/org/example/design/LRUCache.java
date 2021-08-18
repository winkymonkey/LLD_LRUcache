package org.example.design;

import java.util.HashMap;


public class LRUCache {

	private final HashMap<String, Node> map;
	private final int capacity;

	private Node head = null;
	private Node tail = null;

	public LRUCache(int capacity) {
		this.map = new HashMap<>();
		this.capacity = capacity;
	}
	
	
	
	public String get(String key) {
		if (!map.containsKey(key))
			return null;
		
		Node node = map.get(key);
		
		deleteFromList(node);
		setListHead(node);
		
		return node.getValue();
	}
	
	
	/*
	 * Always add items to the HEAD of the list
	 * While update, move item to the HEAD of the list
	 */
	public void put(String k, String v) {
		if (map.containsKey(k)) { 				// update scenario
			Node node = map.get(k);
			node.setValue(v);
			
			deleteFromList(node);
			setListHead(node);
		}
		else { 										// put scenario
			if (map.size() >= capacity) {
				map.remove(tail.getKey());
				deleteFromList(tail);
			}
			
			Node node = new Node(k, v);
			map.put(k, node);
			
			setListHead(node);
		}
	}
	
	
	private void deleteFromList(Node node) {
		if (node.prev != null)
			node.prev.next = node.next;
		else
			head = node.next;
		
		if (node.next != null)
			node.next.prev = node.prev;
		else
			tail = node.prev;
	}
	
	
	/*
	 * Set the node as HEAD of the Doubly Linked List
	 */
	private void setListHead(Node node) {
		node.next = head;
		node.prev = null;
		
		if (head != null)
			head.prev = node;
		head = node;
		
		if (tail == null)
			tail = head;
	}
	
}