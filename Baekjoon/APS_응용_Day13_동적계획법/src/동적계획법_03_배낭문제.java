import java.util.Iterator;
import java.util.Scanner;

public class 동적계획법_03_배낭문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int N = sc.nextInt(); //물건 개수
		int W = sc.nextInt(); //가방 최대 무게
		//2차원 배열, 1차원 배열 2개, 또는 클래스
		
		int[] weights = new int[N+1];
		int[] cost = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][W+1];
		//물건을 하나도 고려하지 않았을 때를 초기화시켜줘야 하지만, 0행은 이미 0으로 초기화되어있음
		//물건을 하나씩 고려하면서 처리해보자
		for (int i = 1; i <= N; i++) {
			//i번째 물건까지 고려한 경우가 저장이 됨
			//임시 배낭의 크기
			
			for (int w = 0; w <= W; w++) {
				if(weights[i] <= w) {
					//해당 물건을 이제 판단해보겠다
					//현재 해당 무게에서의 최적해는 dp[i-1][w]
					//이번에 물건을 고려한 최적해는 dp[i-1][w-weights[i]] + cost[i]
					//위의 두 가지 경우 중 베스트 값을 저장하겠다
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + cost[i]);
				} else {
					dp[i][w] = dp[i-1][w]; //현재 고려할 물건의 무게가 임시 무게를 벗어나 고려할 수 없을 때
				}
			}
		} //물건을 한개씩 고려하겠다
		System.out.println(dp[N][W]);
	}
	public static String input = "4 10\r\n" + "5 10\r\n" + "4 40\r\n" + "6 30\r\n" + "3 50\r\n" + "";
}