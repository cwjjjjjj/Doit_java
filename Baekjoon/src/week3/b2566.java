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
		int max = -1; //모든 숫자가 0일 수 있기 때문에 최소값 -1로 줘야 함!
		for(int i = 0; i <9 ; i++ ) {
			for(int j = 0; j < 9; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
					a = i+1; //1행부터 주어짐
					b = j+1;		
				}
			}
		}
		System.out.println(max);
		System.out.printf(a + " " + b);
	}
}