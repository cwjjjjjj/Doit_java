import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법_01_피보나치 {
	static int callFibo1, callFibo2;
	static int[] memo;
	
	static {
		memo = new int[1000];
		memo[0] = 0;
		memo[1] = 1;
		//여기서 전부 미리 계산해놓겠다
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		memo[0] = 0; //어차피 0으로 초기화되기 때문에 이 부분은 필요없긴 함
		memo[1] = 1;
		 
//		System.out.println(fibo(N));
//		System.out.println(callFibo1);
		System.out.println("---------------------");
		System.out.println(fibo2(N));
		System.out.println(callFibo2);
		System.out.println(fibo3(N));
	} //main
	
	public static long fibo3(int n) {
		long[] dp = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public static int fibo2(int n) {
		 callFibo2++;
		 if(memo[n] == -1) {
//		 if(n >= 2 && memo[n] == 0) { //n이 2보다 크면서, 지금 구하고자 하는 memo[n]이 아직 구해지지 않아 0이라면
			 memo[n] = fibo2(n-1) + fibo2(n-2);
		 }
		 return memo[n]; 
	}
	
	public static int fibo(int n) {
		callFibo1++;
		//기저조건
//		if(n == 0) return 0;
//		if(n == 1) return 1;
//		if(n <= 1) return n;
		
		if(n<2)
			return n;
		return fibo(n-1) + fibo(n-2);
		//무수히 많은 함수 호출이 생긴다는 문제가 있음
		
		//재귀조건
	}
}