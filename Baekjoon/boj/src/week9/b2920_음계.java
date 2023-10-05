package week9;

import java.util.Scanner;

public class b2920_음계 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = "";

		int[] nums = new int[8];
		for (int i = 0; i < 8; i++) {
			nums[i] = sc.nextInt();
		}
			if (nums[0] > nums[1]) {
				ans = "descending";
			} else if (nums[0] < nums[1]) {
				ans = "ascending";
			}
			
		for (int i = 2; i < 8; i++) {
			if (ans.equals("descending"))
				if (nums[i - 1] < nums[i]) {
					ans = "mixed";
					break;
				}
			if (ans.equals("ascending"))
				if (nums[i - 1] > nums[i]) {
					ans = "mixed";
					break;
				}
		}
		System.out.println(ans);
	}
}