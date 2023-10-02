package SWEA_1970_쉬운_거스름돈;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] dp = new int[N+1];
			
			for (int i = 10; i <= N ; i++) {
				int min = Integer.MAX_VALUE; //i원에 대한 거스름돈의 최소 개수
				//10원을 작은 부분문제에 추가
				min = Math.min(min, dp[i-1]+1);
				//50원을 
			}
			
		}
		
	}
	
	
}