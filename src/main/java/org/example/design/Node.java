package org.example.design;


public class Node {
    private final String key;      //cache key
    private String value;          //cache value
    
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}


	public Node prev;
    public Node next;
    
}
