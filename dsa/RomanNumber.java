package dsa;

public class RomanNumber {

	public static void main(String[] args) {

		RomanNumber input = new RomanNumber();
		String str = "LVIII";
		System.out.println("Integer form of Roman Numeral is : " + input.RomanToInt(str));
	}

	public int RomanToInt(String str) {

		int nums[] = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {

			switch (str.charAt(i)) {
			case 'I':
				nums[i] = 1;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'X':
				nums[i] = 10;
				break;
			case 'L':
				nums[i] = 50;
				break;
			case 'C':
				nums[i] = 100;
				break;
			case 'D':
				nums[i] = 500;
				break;
			case 'M':
				nums[i] = 1000;
				break;

			}
		}

		int sum = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				sum -= nums[i];
			else
				sum += nums[i];
		}

		return sum + nums[nums.length - 1];
	}

}
//Time complexity O(n)