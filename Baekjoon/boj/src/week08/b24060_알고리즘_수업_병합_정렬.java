package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b24060_알고리즘_수업_병합_정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //배열 A의 크기 N
		int K = Integer.parseInt(br.readLine()); //저장횟수
		int r = N-1;
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			int n = 0;
			A[i] = Character.getNumericValue(tmp.charAt(n++));
		}
		System.out.println(Arrays.toString(A));
		
	}
	
	public static void merge_sort(int[] A, int l, int r) {
		int mid;
		if(l < r) {
			mid = (l + r / 2); //중간 지점
			merge_sort(A, l, mid); //전반부 정렬
			merge_sort(A, mid+1, r);
			merge(A, l, mid, r); //병합
		}
	}
	
	public static void merge(int[] A, int l, int mid, int r) {
		int i = l;
		int j = mid+1;
		int t = 1;
		
		int[] tmp = null;
		while(i <= mid && j <= r) {
			if(A[i] <= A[j]) {
				tmp[t++] = A[i++];
			} else {
				tmp[t++] = A[j++];
			}
		}
		while(i <= mid) { //왼쪽 배열 부분이 남은 경우
			tmp[t++] = A[i++];
		}
		while(j <= r) { //오른쪽 배열 부분이 남은 경우
			tmp[t++] = A[j++];
		}
		i = l;
		t = 1;
		while(i <= r) {
			A[i++] = tmp[i++];
		}
	}
}