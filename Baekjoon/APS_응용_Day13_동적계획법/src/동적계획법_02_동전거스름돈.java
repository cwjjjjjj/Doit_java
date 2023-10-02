import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법_02_동전거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt(); //해당 거스름돈에 대한 최소 동전 개수를 구하고 싶다
		//사용할 수 있는 동전은 3가지 : 1원, 4원, 6원
		
		int[] dp = new int[money+1];
		
		for (int i = 1; i <= money; i++) {
			int min = Integer.MAX_VALUE; //i원에 대한 거스름돈의 최소 개수
			//1원을 작은 부분문제에 추가하겠다
			min = Math.min(min, dp[i-1]+1);
			//4원을 작은 부분문제에 추가하겠다
			if(i >= 4) {
				min = Math.min(min, dp[i-4]+1);
			} 
			if(i >= 6) {
				min = Math.min(min, dp[i-6]+1);
			}
			////여기까지 왔다면... 1, 4, 6원까지 고려할 수 있으며, 전부 고려했다
			dp[i] = min;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[money]);
	}
}