package SWEA_1251_하나로_프림;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1251_하나로_프림/input.txt");
		Scanner sc = new Scanner(file);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt(); //tc의 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //섬 개수
			int[][] location = new int[N+1][3]; //[0]: x 좌표, [1]: y 좌표, [2]: 거리 L
			for (int i = 1; i <= N; i++) { //x 좌표, 0번 인덱스 사용하지 않음
				location[i][0] = sc.nextInt();
			}
			for (int i = 1; i <= N; i++) { //y 좌표
				location[i][1] = sc.nextInt();
			}

			
		}
		
	}
}