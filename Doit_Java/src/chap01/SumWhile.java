package chap01;

import java.util.Scanner;

public class SumWhile {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구합니다");
		System.out.println(("n값: "));
		int n = stdIn.nextInt();
		
		int sum = 0; //합
		int i = 1;
		
		while (i<= n) { //i가 n 이하면 반복
			sum += i;
			i++; //1 증가
		}
		System.out.println("1부터 " +n+ "까지의 합은 "+sum+"입니다.");
		//while문 밖에서 출력해야 함!!
	}

}
