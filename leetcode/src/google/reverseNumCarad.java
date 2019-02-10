package google;

import java.util.ArrayList;
import java.util.HashMap;

public class reverseNumCarad {
	private static ArrayList<Integer> notValid = new ArrayList();
	private static HashMap<Integer, Integer> map = new HashMap();
	public static void main(String[] args) {
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
		for (int i = 0; i <= 650; i++) {
			//System.out.println(i);
			solution(i);
		}
		solution(169);
		for (int i = 0; i < notValid.size() - 1; i++) {
			System.out.println(notValid.get(i) + ", ");
		}
		System.out.println(notValid.get(notValid.size() -1 ));
	}
	
	public static void solution(int num) {
		String strNum = Integer.toString(num);
		StringBuilder sb = new StringBuilder();
		for (int i = strNum.length() - 1; i >= 0; i--) {
			if (map.containsKey(strNum.charAt(i) - '0')) {
				sb.append(map.get(strNum.charAt(i) - '0').toString());
			} else {
				return;
			}	
		}
		strNum = sb.toString();
		System.out.println(strNum);
		int ans = Integer.parseInt(strNum);
		if (ans > 650 || ans == num) {
			return;
		} else {
			notValid.add(ans);
		}
	}
}
