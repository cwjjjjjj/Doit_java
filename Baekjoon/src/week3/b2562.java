package week3;

import java.util.Scanner;

public class b2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		
		int max = 0;
		int n =-1;
		for(int i = 0; i < 9; i++) {
			arr[i]=sc.nextInt();
		}
		for(int i = 0; i < 9; i++) {
			if (arr[i]>max) {
				max = arr[i];
				n = i;
			}
		}
		System.out.println(max);
		System.out.println(n+1);
	}

}
