package week2;

import java.util.Scanner;

public class b10952 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) { //조건 true로 주기
			int A= sc.nextInt();
			int B= sc.nextInt();  
			if(A == 0 && B == 0) { //여기서 나가기
				break;
			}
			System.out.println(A+B); //아래에서 출력하기
		}
	}
}
