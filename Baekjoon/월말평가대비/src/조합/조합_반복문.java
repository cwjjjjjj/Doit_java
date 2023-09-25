package 조합;

public class 조합_반복문 {
	public static void main(String[] args) {
		//{1, 2, 3, 4} 중 원소 3개 뽑기
		
		for (int i = 1; i <= 2; i++) {
			for (int j = i+1; j <= 3; j++) {
				for (int k = j+1; k <= 4; k++) {
					System.out.println(i);
					System.out.println(j);
					System.out.println(k);
				}
			}
		}
	}
}