package whitepages;

public class dragon {
	public static void main(String[] args) {
		int[] test1 = {7, 1, 1, 3, 4};
		int[] test2 = {3, 2, 1, 1, 4};
		int[] test3 = {5,6,0,4,2,4,1,0,0,4};
		dragonJump(test1);
		dragonJump(test2);
		dragonJump(test3);
	}
	
	public static void dragonJump(int[] arr) {
		if (arr.length < 1) {
			System.out.println("failure1");
		}
		
		int nextBegin = 0;
		int currEnd = 0;
		int currFarthest = 0;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		while (i < arr.length) {
			int dis = i + arr[i];
			if (dis > currFarthest) {
				currFarthest = dis;
				nextBegin = i;
			}
			if (dis >= arr.length) {
				sb.append(nextBegin);
				System.out.println(sb.toString());
				return;
			}
			if (i == currEnd) {
				if (currFarthest <= currEnd) {
					System.out.println("failure2");
				}
				sb.append(nextBegin);
				currEnd = currFarthest;
			}
			i++;
		}
		System.out.println("failure3");
	}
}
