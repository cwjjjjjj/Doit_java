package week3;

import java.util.Scanner;

public class b10810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int n = 0; n < M; n++) { //공넣기를 M번 반복
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			for(int a = i; a <= j; a++) {
				arr[a-1] = k;
			}
		}
		for(int n = 0; n < N; n++) {
		System.out.printf(arr[n]+" ");
		}
	}
}
