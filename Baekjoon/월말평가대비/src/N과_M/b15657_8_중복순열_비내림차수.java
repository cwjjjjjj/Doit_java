package N과_M;

import java.util.Arrays;
import java.util.Scanner;

public class b15657_8_중복순열_비내림차수 {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		sel = new int[M];
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		perm(0, nums);
		System.out.println(sb);
	}
	
	static void perm(int idx, int[] nums) {
		if(idx == M) {
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if(idx >= 1 && sel[idx-1]> nums[i]) {
				continue;
			}
			sel[idx] = nums[i];
			perm(idx+1, nums);
		}
	}
}