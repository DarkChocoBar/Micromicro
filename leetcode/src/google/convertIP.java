package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class convertIP {
	public static void main(String[] args) {

		
		int test1 = 45444444;
		
		System.out.println("test 1: " + solution(test1));
	}
	
	
	public static String solution(int number) {
		Stack<String> res = new Stack();
		for (int i = 0; i < 4; i++) {
			int remainer = number % 256;
			number = number / 256;

			res.push(Integer.toString(remainer));
		}
		ArrayList<String> arr = new ArrayList();
		
		int size = res.size();
		for (int i = 0; i < size; i++) {
			arr.add(res.pop());
		}
		
		return String.join(",", arr);
	}
}
