package 조합;

import java.util.Arrays;

public class 조합_재귀 {
	
	static int[] data; //data[] : n개의 원소를 가지고 있는 배열
	static int[] sel; //sel[] : r개의 크기의 배열, 조합이 임시 저장될 배열
	
	public static void main(String[] args) {
		
	}
	
	static void comb(int n, int r) {
		if(r==0) {
			System.out.println(Arrays.toString(sel));
		} else if(n < r) {
			return;
		} else {
			sel[r-1] = data[n-1];
			comb(n-1, r-1);
			comb(n-1, r);
		}
	}
}