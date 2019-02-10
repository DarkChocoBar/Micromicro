package google;
import java.util.*;
public class googleOA {


		
	public static void main(String[] args) {
//		if(dmgGame(5,4,new int[]{4,5,1}, new int[]{1,4,2})) System.out.println("Win");
//		else System.out.println("Lose");
		System.out.println(compareByDelete("abc","acb"));
	}
	
	public static int compareByDelete(String a, String b) {
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();
		int i = 0, j = 0;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] == arr2[j]) j++;
			i++;
		}
		return j == arr2.length ? 1 : 0;
	}
	
	public static boolean dmgGame(int totalMoney, int hp, int[] cost, int[] dmg) {
		boolean[] visited = new boolean[cost.length];
		for(int i = 0; i < cost.length; i++) {
			visited[i] = true;
			if(dmgRecur(totalMoney - cost[i], hp - dmg[i], cost, dmg, visited)) return true;
			visited[i] = false;
		}
		return false;
	}
	
	public static boolean dmgRecur(int currMoney, int currHp, int[] cost, int[] dmg, boolean[] visited) {
		if(currHp <= 0) return true;
		for(int i = 0; i < cost.length; i++) {
			if(!visited[i] && cost[i] <= currMoney) {
				visited[i] = true;
				if(dmgRecur(currMoney - cost[i], currHp - dmg[i], cost, dmg, visited)) return true;
				visited[i] = false;
			}
		}
		return false;
	}
	
	
	public static int bloom(int[] p, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < p.length; i++) map.put(p[i], i);
		TreeSet<Integer> s = new TreeSet<>();
		s.add(-1);
		s.add(p.length);
		int day = 0;
		for(int i = 1; i <= p.length; i++) {
			int currIndex = map.get(i);
			int highBound = s.higher(currIndex);
			int lowBound = s.lower(currIndex);
			if(currIndex - lowBound - 1 == k || highBound - currIndex - 1 == k) {
				day = Math.max(day, i);
			} else {
				s.add(currIndex);
			}
			
			
		}
		return -1;
	}
	
	
	
	
	
	public static String nextClock1(String str) {
		char[] cStr = str.toCharArray();
		int[] curr = new int[4];
		curr[0] = cStr[0] - '0';
		curr[1] = cStr[1] - '0';
		curr[2] = cStr[3] - '0'; 
		curr[3] = cStr[4] - '0';
		int[] check = new int[10];
		for(int each : curr) check[each]++;
		boolean found = false;
		int currMin = convertToMin(curr);
		int[] now = new int[4];
		while(!found) {
			currMin++;
			now = convertToTime(currMin);
			if(check1(check, now)) found = true;
		}
		return build(now);
	}
	
	public static boolean check1(int[] check, int[] a) {
		int[] now = new int[10];
		for(int each : a) now[each]++;
		for(int i = 0; i < 10; i++) if(now[i] != check[i]) return false;
		return true;
	}
	
	
	public static String nextClock(String str) {
		boolean[] check = new boolean[10];
		char[] cStr = str.toCharArray();
		int[] curr = new int[4];
		curr[0] = cStr[0] - '0';
		curr[1] = cStr[1] - '0';
		curr[2] = cStr[3] - '0'; 
		curr[3] = cStr[4] - '0';
		check[curr[0]] = true;
		check[curr[1]] = true;
		check[curr[2]] = true;
		check[curr[3]] = true;
		boolean found = false;
		int currMin = convertToMin(curr);
		int[] now = new int[4];
		while(!found) {
			currMin++;
			now = convertToTime(currMin);
			if(check(check, now)) found = true;
		}
		return build(now);
	}
	
	public static String build(int[] a) {
		return a[0] + a[1] + ":" + a[2] + a[3];
	}
	
	public static boolean check(boolean[] a, int[] b) {
		for(int each : b) if(!a[each]) return false;
		return true;
	}
	
	public static int convertToMin(int[] time) {
		return (time[0] * 10 + time[1]) * 60 + time[2] * 10 + time[3];
	}
	
	public static int[] convertToTime(int time) {
		time %= (24 * 60);
		int hours = time % 60;
		int mins = time / 60;
		int[] curr = new int[4];
		curr[0] = hours / 10;
		curr[1] = hours % 10;
		curr[2] = mins / 10;
		curr[3] = mins % 10;
		return curr;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static int window(int[] arr) {
		int ans = 0;
		int[][] matrix = new int[2][2];

		int start = 0;
		int end = 0;
		
		while(end < arr.length) {
			int temp = arr[end];
			if(matrix[0][1] == 0) {
				matrix[0][0] = temp;
				matrix[0][1] = 1;
				end++;
			} else if(temp == matrix[0][0]) {
				matrix[0][1]++;
				end++;
			} else if(matrix[1][1] == 0){
				matrix[1][0] = temp;
				matrix[1][1] = 1;
				end++;
			} else if(temp == matrix[1][0]) {
				matrix[1][1]++;
				end++;
			} else {
				ans = Math.max(ans, end - start);
				while(matrix[0][1] != 0 && matrix[1][1] != 0) {
					int tmp = arr[start];
					if(tmp == matrix[0][0]) matrix[0][1]--;
					else matrix[1][1]--;
					start++;
				}
			}	
		}
		ans = Math.max(ans, end - start);
		
		
		return ans;
	}
	
	
	
	
	public static int busket(int[] arr) {
		int ans = 0;
		int buket = 0;
		int type1 = -1;
		int type2 = -1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				if(type1 == -1 && type2 == -1) {
					type1 = arr[j];
					buket++;
				} else if(type2 == -1) {
					type2 = arr[j];
					buket++;
				} else {
					if(arr[j] == type1 || arr[j] == type2) {
						buket++;
					} else {
						break;
					}
				}
			}
			ans = Math.max(buket, ans);
			type1 = -1;
			type2 = -1;
			buket = 0;
		}
		return ans;
	}
	
	
	
	
	
	public static int emails(Map<String, Integer> map, List<String> emails) {
		int ans = 0;
		for(String each : emails) {
			String step1 = "";
			String step2 = "";
			boolean domain = false;
			for(char c : each.toCharArray()) {
				if(c == '@') domain = true;
				if(!domain) {
					step1 += c;
				} else {
					step2 += c;
				}
			}
			
			String str = "";
			for(char c : step1.toCharArray()) {
				if(c == '+') break;
				else if(c == '.') continue;
				else str += c;                                                        
			}
			str += step2;
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key is: " + entry.getKey() + ", value is: " + entry.getValue());
			if(entry.getValue() > 1) ans++;
		}
		
		return ans;
	}
	
	
	public static int email(Map<String, Integer> map, List<String> emails) {
		int ans = 0;
		for(String each : emails) {
			String[] step1 = each.split("@");
			String[] step2 = step1[0].split("\\+");
			String[] step3 = step2[0].split("\\."); 
			String str = "";
			for(String ea : step3) {
				str += ea;
			}
			str += "@" + step1[1];
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key is: " + entry.getKey() + ", value is: " + entry.getValue());
			if(entry.getValue() > 1) ans++;
		}
		return ans;
		
	}

}
