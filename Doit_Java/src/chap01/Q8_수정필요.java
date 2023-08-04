package chap01;

import java.util.Scanner;

public class Q8_수정필요 {
//	public static void main(String[] args) {
		
	static int sumof(int a, int b) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		int sum = 0;
		if(a < b) {
			for(int i = a; i <= b+1; i++) {
				sum += i;
				System.out.println(i);
			}
		} else {
			for(int i = b; i <= a+1; i++) {
				sum += i;
			}
		}
//		System.out.println(sum);
		return sum;
	}
	}