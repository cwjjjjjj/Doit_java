package 조합;

import java.util.Arrays;
import java.util.Iterator;

public class 조합_반복문재귀 {
	
	static int[] data; //n개의 원소 가진 배열
	static int[] sel; //r개의 크기의 배열. 조합 임시 저장
	static int sidx; //sel 배열의 인덱스
	static int idx; //data 배열의 인덱스
	static int n = data.length;
	static int r = sel.length;
	
	public static void main(String[] args) {
		
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx == r) {
			System.out.println(Arrays.toString(sel));
		} else {
			for (int i = idx; i < n-r+sidx; i++) {
				sel[sidx] = data[i];
				comb(i+1, sidx+1);
			}
		}
		
	}
}