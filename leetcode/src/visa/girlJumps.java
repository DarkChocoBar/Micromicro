package visa;

public class girlJumps {
	public static void main(String[] args) {
		
		int[] test = {1,68,1,4,4,4,4,71,85,71,71,71,98,98,71,71,15,2,49,49,49,13,49,49,49,49,13,17,17,48,48,17,17,17,17,90,0,0,90,90,90,0,0,0,90	,0,7,89,7,7,42,91,91,91,42,91,59,59,87,59,59,91,59,42,42,59,42,42,59,42,59,42,42,42,42,89,1,1,1,62,1,65,1,1,1,1,1,1,42,40,96,0,96,36,36,96,36,36,96,98};
		
		System.out.println(test[30]);
	}
	
	public static int girlJumpsRoad(String input) {
		if (input.length() == 0) {
			return 0;
		}
		
		
		return findMaxPow(input, finalJump(input));
	}
	
	public static Character finalJump(String string) {
		return string.charAt(string.length() - 1);
	}
	
	public static int findMaxPow(String input, Character finalJump) {
		int max = 0;
		int prevBlock = -1;
		for (int i = 0; i < input.length(); i++) {
			Character block = input.charAt(i);
			if (block != finalJump) {
				continue;
			} else {
				max = Math.max(max, i - prevBlock);
				prevBlock = i;
			}
		}
		return max;
	}
}
