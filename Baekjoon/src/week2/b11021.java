package week2;

import java.util.Scanner;

public class b11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int sum = A+B;
			System.out.println("Case #" + tc + ": " +sum);
		}
	}
}
