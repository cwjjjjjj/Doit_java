package 부분집합;

public class 부분집합_재귀호출 {
	static boolean[] sel; //해당 원소 포함 여부 저장
	public static void main(String[] args) {
		//n: 원소의 개수, k: 현재 depth
		
	}
	
	static void powerset(int n, int k) {
		if(n == k) {
			System.out.println(sel); //???
			return;
		}
		
		sel[k] = false; //K번 요소 X
		powerset(n, k+1); //다음 요소 포함 여부 결정
		sel[k] = true; //K번 요소 X
		powerset(n, k+1); //다음 요소 포함 여부 결정
		
	}
}