package 조합;

public class 조합_재귀2 {
	static int[] data; //n개의 원소 가진 배열
	static int[] sel; //r개의 크기의 배열. 조합 임시 저장
	static int n = data.length;
	static int r = sel.length;
	
	public static void main(String[] args) {
		
	}
	
	static void comb(int idx, int sidx) {
		//idx: data 배열의 인덱스
		//sidx: sel 배열의 인덱스
		if(sidx == r) {
			System.out.println(sel);
		} else if(idx >= n) {
			return;
		} else {
			sel[sidx] = data[idx];
			comb(idx+1, sidx+1);
			comb(idx+1, sidx);
		}
	}
}