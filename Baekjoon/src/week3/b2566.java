package week3;

import java.util.Scanner;

public class b2566 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];
		
		for(int i = 0; i <9 ; i++ ) {
			for(int j = 0; j < 9; j++) {
				arr[i][j]= sc.nextInt();
			}
		}
		
		int a = 0;
		int b = 0;
		int max = 0;
		for(int i = 0; i <9 ; i++ ) {
			for(int j = 0; j < 9; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
					a = i+1;
					b = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.printf(a + " " + b);
	}
}