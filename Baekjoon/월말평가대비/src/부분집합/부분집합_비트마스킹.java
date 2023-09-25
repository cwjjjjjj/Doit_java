package 부분집합;

import java.util.Scanner;

public class 부분집합_비트마스킹 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //원소의 개수
		//부분집합의 수만큼 반복 돌리기
		for (int i = 0; i < (1 << N); i++) {
			//i라는 부분집합에 원소 확인하기
			for (int j = 0; j < N; j++) {
				//해당 i값에 j번째 비트가 존재한다면
				if((i & (1 << j)) >0) {
					//처리
				}
			}
		}
	}
}