package microsoft;

import java.util.HashMap;

class Solution2 {
	class LRUCache {

	    class DoubleLinkedList {
	        int val;
	        int key;
	        DoubleLinkedList prev;
	        DoubleLinkedList next;
	    }
	    
	    HashMap<Integer, DoubleLinkedList> cache;
	    
	    int count = 0;
	    int curCapacity = 0;
	    
	    DoubleLinkedList head;
	    DoubleLinkedList tail;
	    
	    public LRUCache(int capacity) {
	        this.count = 0;
	        this.curCapacity = capacity;
	        
	        this.cache = new HashMap<>();
	        
	        this.head = new DoubleLinkedList();
	        this.tail = new DoubleLinkedList();
	        this.head.prev = null;
	        this.head.next = this.tail;
	        this.tail.prev = this.head;
	        this.tail.next = null;
	        
	    }
	    
	    public int get(int key) {
	        if (cache.containsKey(key)) {
	            // Todo: remove node first
	            int ans = cache.get(key).val;
	            
	            DoubleLinkedList node = cache.get(key);
	            removeNode(node);
	            node.prev = this.head;
	            node.next = this.head.next;
	            this.head.next.prev = node;
	            this.head.next = node;

	            return ans;
	        } else {
	            return -1;
	        }
	    }
	    
	    public void put(int key, int value) {
	        if (this.count < this.curCapacity) {
	            if (cache.containsKey(key)) {
	                // Todo: remove node first
	                DoubleLinkedList node = cache.get(key);
	                removeNode(node);
	                
	                // update node value
	                node.val = value;
	                
	                // put node in the head
	                node.prev = this.head;
	                node.next = this.head.next;
	                this.head.next.prev = node;
	                this.head.next = node;
	                
	                // update cache
	                cache.put(key, node);
	            } else {
	                DoubleLinkedList node = new DoubleLinkedList();
	                node.key = key;
	                node.val = value;
	                node.prev = this.head;
	                node.next = this.head.next;
	                this.head.next.prev = node;
	                this.head.next = node;
	                this.count++;
	                
	                cache.put(key, node);
	            }
	        } else {
	            if (cache.containsKey(key)) {
	                // Todo: remove node first
	                DoubleLinkedList node = cache.get(key);
	                removeNode(node);
	                node.val = value;
	                node.prev = this.head;
	                node.next = this.head.next;
	                this.head.next.prev = node;
	                this.head.next = node;
	                
	                cache.put(key, node);
	            } else {
	                DoubleLinkedList node = new DoubleLinkedList();
	                node.key = key;
	                node.val = value;
	                node.prev = this.head;
	                node.next = this.head.next;
	                this.head.next.prev = node;
	                this.head.next = node;
	                
	                // remove tail
	                cache.remove(this.tail.prev.key);
	                
	                removeNode(this.tail.prev);
	                
	                cache.put(key, node);
	            }
	        }
	    }
	    
	    public void removeNode(DoubleLinkedList node) {
	        DoubleLinkedList prev = node.prev;
	        DoubleLinkedList next = node.next;
	        prev.next = next;
	        next.prev = prev;
	    }
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}

public class LRUCache {
	    class DoubleLinkedNode {
	        int val;
	        int key;
	        DoubleLinkedNode next;
	        DoubleLinkedNode prev;
	        
	    }
	    
	    // for calculating the capacity and current content count in the hashmap
	    private int capacity;
	    private int count;
	    
	    // hash map to store the seen nodes
	    private HashMap<Integer, DoubleLinkedNode> cache;
	    
	    private DoubleLinkedNode head;
	    private DoubleLinkedNode tail;
	    
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.count = 0;
	        this.cache = new HashMap<>();
	        
	        head = new DoubleLinkedNode();
	        tail = new DoubleLinkedNode();
	        head.next = tail;
	        tail.prev = head;
	        head.prev = null;
	        tail.next = null;
	    }
	    
	    public int get(int key) {
	        DoubleLinkedNode res = this.cache.get(key);
	        if (res == null) {
	            return -1;
	        } else {
	            
	            this.moveToHead(res);
	            return res.val;
	        }
	    }
	    
	    public void put(int key, int value) {
	        DoubleLinkedNode node = this.cache.get(key);
	        if (node != null) {
	            node.val = value;
	            this.moveToHead(node);
	        } else {
	            DoubleLinkedNode newNode = new DoubleLinkedNode();
	            newNode.key = key;
	            newNode.val = value;
	            
	            this.cache.put(key, newNode);
	            this.addNode(newNode);
	            
	            this.count++;
	            if (count > capacity) {
	                int returnedKey = this.removeTail();
	                this.cache.remove(returnedKey);
	                count--;
	            }           
	        }
	         
	        
	    }
	    
	    public int removeTail() {
	        DoubleLinkedNode tprev = this.tail.prev;
	        this.removeNode(tprev);
	        return tprev.key;
	    }
	    
	    public void moveToHead(DoubleLinkedNode node) {
	        this.removeNode(node);
	        this.addNode(node);
	    }
	    
	    public void removeNode(DoubleLinkedNode node) {
	        DoubleLinkedNode prev = node.prev;
	        DoubleLinkedNode next = node.next;
	        prev.next = next;
	        next.prev = prev;
	    }
	    
	    //我们的implementation有点独特，我们一直把node放在head的后面
	    //我们的head实际上是一个假的node，有很多好处
	    //不用查null等等
	    public void addNode(DoubleLinkedNode node) {
	        DoubleLinkedNode hnext = this.head.next;
	        node.prev = this.head;
	        node.next = hnext;
	        hnext.prev = node;
	        head.next = node;
	    }
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
