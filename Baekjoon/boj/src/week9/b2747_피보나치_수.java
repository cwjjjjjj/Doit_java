package week9;

import java.util.Arrays;
import java.util.Scanner;

public class b2747_피보나치_수 {
	
	static int[] memo; //메모이제이션
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //n번째 피보나치 수 구하기
		memo = new int[n+1]; //인덱스 0번째 숫자가 1번이 아니라 0번 숫자임
		
		Arrays.fill(memo, -1); //-1로 다 채우기
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println(Fibo(n));
	}
	
	private static int Fibo(int n) {
		if(memo[n] == -1) {
			memo[n] = Fibo(n-1) + Fibo(n-2);
		}
		return memo[n];
	}
}