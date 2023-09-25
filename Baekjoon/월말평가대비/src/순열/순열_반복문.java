package 순열;

import java.util.Iterator;

public class 순열_반복문 {
	public static void main(String[] args) {
		//{1, 2, 3}을 표현하는 모든 순열 생성하는 함수
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if(i != j) {
					for (int k = 1; k <= 3 ; k++) {
						if(k != i && k != j) {
							System.out.println(i);
							System.out.println(j);
							System.out.println(k);
						}
					}
				}
			}
		}
	}
}