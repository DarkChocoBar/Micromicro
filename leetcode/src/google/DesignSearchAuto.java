package google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;
import java.util.List;
import java.util.PriorityQueue;

public class DesignSearchAuto {
	class AutocompleteSystem {
	    public TrieNode root;
	    public String prevCmd = "";
	    public AutocompleteSystem(String[] sentences, int[] times) {
	        this.root = new TrieNode();
	        TrieNode temp = this.root;
	        for (int i = 0; i < sentences.length; i++) {
	            //System.out.println(sentences[i]);
	            char[] carr = sentences[i].toCharArray();
	            int time = times[i];
	            for (int j = 0; j < carr.length; j++) {
	                char c = carr[j];
	                if (!temp.map.containsKey(c)) {
	                    temp.map.put(c, new TrieNode());
	                }
	                temp = temp.map.get(c);
	                temp.count.put(sentences[i], temp.count.getOrDefault(sentences[i], 0) + time);
	                //System.out.println("current ch is:" + c + " putting sentence: " + sentences[i] + " size is: " + temp.count.size());
	            }
	            temp.isSen = true;
	            temp = this.root;
	        }
	    }
	    
	    public void add(String str, int time) {
	        char[] carr = str.toCharArray();
	        TrieNode temp = this.root;
	        for (int j = 0; j < carr.length; j++) {
	            char c = carr[j];
	            if (!temp.map.containsKey(c)) {
	                temp.map.put(c, new TrieNode());
	            }
	            temp = temp.map.get(c);
	            temp.count.put(str, temp.count.getOrDefault(str, 0) + time);
	        }
	        temp.isSen = true;        
	    }
	    
	    public List<String> input(char c) {
	        if (c == '#') {
	            add(prevCmd, 1);
	            prevCmd = "";
	            return new ArrayList<String>();
	        }
	        
	        prevCmd += c;
	        TrieNode temp = this.root;
	        //System.out.println(prevCmd);
	        for (char ch : prevCmd.toCharArray()) {
	            if (!temp.map.containsKey(ch)) {
	                return new ArrayList<String>();
	            }
	            temp = temp.map.get(ch);
	        }
	        
	        PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new FreqCom());
	        //System.out.println("current prevcmd is:" + prevCmd + ".");
	        //System.out.println("size is: " + temp.count.size());
	        for (String s : temp.count.keySet()) {
	            pq.add(new Freq(s, temp.count.get(s)));
	        }
	        ArrayList<String> ans = new ArrayList();
	        for (int i = 0; i < 3; i++) {
	            if (!pq.isEmpty()) {
	                ans.add(pq.poll().s);
	            }
	        }
	        return ans;
	    }
	    
	    class TrieNode {
	        Map<String, Integer> count = new HashMap<>();
	        boolean isSen = false;
	        Map<Character, TrieNode> map = new HashMap<>();
	    }
	    
	    class FreqCom implements Comparator<Freq> {
	        public int compare(Freq o1, Freq o2) {
	            if (o1.times == o2.times) {
	                return o1.s.compareTo(o2.s);
	            } else {
	                if (o1.times > o2.times) {
	                    return -1;
	                } else if (o1.times < o2.times) {
	                    return 1;
	                } else {
	                    return 0;
	                }
	            }
	        }
	    }
	    
	    class Freq{
	        String s;
	        int times;
	        
	        public Freq(String s, int times) {
	            this.s = s;
	            this.times = times;
	        }
	    }
	}

	/**
	 * Your AutocompleteSystem object will be instantiated and called as such:
	 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
	 * List<String> param_1 = obj.input(c);
	 */
}
