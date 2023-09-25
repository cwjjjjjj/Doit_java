package 부분집합;

import java.util.Arrays;
import java.util.Iterator;

public class 부분집합_반복문 {
	public static void main(String[] args) {
		int[] sel = {1, 2, 3, 4};
		for (int i = 0; i <= 1; i++) {
			sel[0]= i;
			for (int j = 0; j <= 1; j++) {
				sel[1] = j;
				for (int k = 0; k <= 1 ; k++) {
					sel[2] = k;
					for (int l = 0; l <= 1; l++) {
						sel[3] = l;
						System.out.println(Arrays.toString(sel));
					}
				}
			}
		}
	}
}