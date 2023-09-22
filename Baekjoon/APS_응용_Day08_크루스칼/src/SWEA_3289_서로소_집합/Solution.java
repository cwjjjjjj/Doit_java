package SWEA_3289_서로소_집합;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_3289_서로소_집합/input.txt");
		Scanner sc = new Scanner(file);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt(); // tc의 개수

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 집합의 개수
			int m = sc.nextInt(); // 연산의 개수
			
			//집합 생성
			int[] p = new int[n+1]; // 대표를 저장할 배열
			for (int i = 1; i <= n; i++) { //0번 인덱스 비어있음
				makeset(i, p);
			}

			// 0 a b 합집합
			// 1 a b 같은 집합 소속인지 검사 -> 같으면 1 아니면 0
			sb.append("#").append(tc).append(" ");
			for (int i = 1; i <= m; i++) { //m개의 연산을 하나씩 처리
				int order = sc.nextInt();
				if(order == 0) { //합집합
					int a = sc.nextInt();
					int b = sc.nextInt();
					union(a, b, p);
				} else if(order == 1) { //같은 집합 소속인지 검사
					int a = sc.nextInt();
					int b = sc.nextInt();
					if(findset(a, p) == findset(b, p)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb);
			sb = new StringBuilder();
		} //tc
	} //main
	
	static void makeset(int i, int[] p) {
		p[i] = i;
	}

	static void union(int a, int b, int[] p) {
		p[findset(a, p)] = findset(b, p);
	}

	static int findset(int a, int[] p) {
		if (a != p[a]) {
			p[a] = findset(p[a], p);
		}
		return p[a];
	}
}