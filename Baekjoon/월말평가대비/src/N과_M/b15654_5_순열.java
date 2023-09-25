package N과_M;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class b15654_5_순열 {
	//순서 상관있음.
	//같은 숫자 중복으로 뽑는 건 안 됨
	
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] nums = new int[N];
	static int[] sel = new int[M];
	static boolean[] visited = new boolean[N];
	
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		} //배열 입력받음
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
			if(visited[i]) {
				continue;
			}
			sel[idx] = nums[i];
			visited[i] = true;
			
			perm(idx+1, nums);
			visited[i] = false;
  		}
	}
}