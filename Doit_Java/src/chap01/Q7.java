package chap01;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum = 0;
		if (n%2 == 0) {
		sum = (1 + n)*(n / 2);
		} else {
			sum = (1 + n)*(n / 2) + (n / 2) +1;
		}
		//int sum = (n+1)*(n/2)+(n%2==0 ? (n+1)/2 : 0);
		System.out.println(sum);
	}
}
