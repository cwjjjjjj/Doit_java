package week3;

import java.util.Scanner;

public class b10807 {
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int[] arr = new int[N];
		
	for(int n = 0; n < N; n++) {
		arr[n] = sc.nextInt();
	} //배열 만들기
	
	int v = sc.nextInt(); //v보다 배열이 더 빨리 들어옴, 나중에 선언하기.
	int cnt = 0;
	for(int i = 0; i < N; i++) {
		if(arr[i] == v) {
			cnt++;
		}
	}
	System.out.println(cnt);
}
}