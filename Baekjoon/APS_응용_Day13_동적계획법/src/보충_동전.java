import java.util.Scanner;

public class 보충_동전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt(); //교환금액
		
		int[] D = new int[money+1]; //금액 n에 대한 최소동전수
		//0번 인덱스부터 사용하므로 +1
		D[0] = 0; //어차피 0이긴 하지만 명확하게 만들기 위해
		
		for (int i = 1; i <= money; i++) {
			//1원 시도
			D[i] = D[i-1] + 1; //셋 중 최소
			
			//4원 시도
			if(i >= 4 && D[i] > D[i-4]+1) { //4원보다 같거나 커야 시도 가능
				//D[i-4]+1는 4원 사용 시 최적해. 이것이 임시 최적해보다 작으면
				D[i] = D[i-4] + 1; //갱신
			}	
			
			//6원 시도
			if(i >= 6 && D[i] > D[i-6]+1) D[i] = D[i-6] + 1;
		}
		System.out.println(D[money]);
	}
}