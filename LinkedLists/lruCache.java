package LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class lruCache {
    private Map<Integer, Node> lruCache = new HashMap<>();
    private int capacity;
    private int currCapacity; 
    private Node head= new Node(-1, -1);
    private Node tail= new Node(-1, -1);
public lruCache(int capacity) {
    this.capacity= capacity;
    this.currCapacity = 0;
    head.next = tail;
    tail.prev= head;    
}  
public int get(int key) {
    if(lruCache.get(key)== null){
        return -1;
    }
    Node node= lruCache.get(key);
    removeNode(node);
    addNode(node);
    return node.value;
    
}
public void put(int key, int value) {
    if(lruCache.get(key) != null){
        Node node= lruCache.get(key);
        node.value= value;
        removeNode(node);
        addNode(node);
    } else{
        if(currCapacity == capacity){
            Node node= tail.prev;
            lruCache.remove(node.key);
            removeNode(node);
            currCapacity--;
        }
            Node newNode = new Node(key, value);
            addNode(newNode);
            lruCache.put(key, newNode);
            currCapacity++;
        }
    }
    public void addNode(Node node){
        Node headNext = head.next;
        head.next= node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;  

    }
    public void removeNode(Node node){
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;    
    }
    class Node{
        int key; 
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

    }

}

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/