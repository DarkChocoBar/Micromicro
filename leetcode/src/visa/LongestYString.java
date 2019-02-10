package visa;

public class LongestYString {
	public static void main(String[] args) {
		String[] test1 = {"YYYYY", "YYYYY", "YYNYY", "YYYYY"};
		String[] test2 = {"YNYYYY", "YYYYYYN", "YYYYNNN"};
		String[] test3 = {};
		String[] test4 = {""};
		String[] test5 = {"Y"};
		String[] test6 = {"N"};
		
		System.out.println(findConStringWithYOnly(test1));
		System.out.println(findConStringWithYOnly(test2));
		System.out.println(findConStringWithYOnly(test3));
		System.out.println(findConStringWithYOnly(test4));
		System.out.println(findConStringWithYOnly(test5));
		System.out.println(findConStringWithYOnly(test6));
	}
	
	public static int findConStringWithYOnly(String[] input) {
		int max = 0;
		int continuous = 0;
		for (int i = 0; i < input.length; i++) {
			String string = input[i];
			if (string.length() == 0) {
				continuous = 0;
			} else {
				if (findYOnly(string)) {
					continuous++;
					max = Math.max(max, continuous);
				} else {
					continuous = 0;
				}

			}
		}
		return max;
	}
	
	public static boolean findYOnly(String string) {
		for (int j = 0; j < string.length(); j++) {
			Character character = string.charAt(j);
			if (character == 'N') {
				return false;
			}
		}
		return true;
	}
}
