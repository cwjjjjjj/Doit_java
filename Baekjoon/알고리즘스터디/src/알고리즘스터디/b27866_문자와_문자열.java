package 알고리즘스터디;

import java.util.Scanner;

public class b27866_문자와_문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); //문자열
		String[] arr = str.split("");

		System.out.println(arr[sc.nextInt()-1]);
	}
}