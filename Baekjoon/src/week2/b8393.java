package week2;

import java.util.Scanner;

public class b8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum = 0;
		if(n%2 == 0) {
			sum = (1+n)* (n/2);
		} else {
			sum = (1+n)* (n/2) + n/2 +1;
		}
		System.out.println(sum);
	}
}
