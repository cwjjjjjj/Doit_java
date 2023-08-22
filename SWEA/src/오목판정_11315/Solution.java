package 오목판정_11315;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/오목판정_11315/sample_input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //tc개수
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //오목판의 크기
			char[][] omok = new char[N][N]; //오목 배열 생성
			
			for(int i = 0; i < N; i++) {
				String tmp = sc.next();
				for(int j = 0; j < N; j ++) {
					omok[i][j] = tmp.charAt(j);	//오목 배열 입력
				}
			}
			String ans = "NO";
			
			//우, 하, 대각선우, 대각선좌
			int cnt = 0;
			for(int i = 0; i < N - 4; i++) { //행범위
				for(int j = 0; j < N - 4; j++) { //열범위
					for(int k = 0; k < 5; k ++) { //아래쪽으로 탐색
						for(int l = 0; l < 5; l++) {
							if(omok[i+k][j+l] == 'o') {
								cnt++;
							}
						}
						if (cnt == 5) {
							ans="YES";
							cnt = 0;
						} else {
							cnt = 0;
						}
					}
					for(int k = 0; k < 5; k ++) { //오른쪽으로 탐색
						for(int l = 0; l < 5; l++) {
							if(omok[j+l][i+k] == 'o') {
								cnt++;
							}
						}
						if (cnt == 5) {
							ans="YES";
							cnt = 0;
						} else {
							cnt = 0;
						}
					}
				}
			}
			//대각선우측으로 탐색 (0,0) 출발
			for(int i = 0; i < N - 4; i++) {
				for (int j = 0; j < 5; j++) {
					if(omok[i+j][i+j]=='o') {
						cnt++;
					}
				}
				if(cnt == 5) {
					ans = "YES";
				}
			}
			//대각선좌측으로 탐색 (0,N-1) 출발
			for(int i = 0; i < N - 4; i++) {
				for(int k = 0; k < 5; k++) {
					if(omok[i+k][N-1-k] == 'o') {
						cnt++;
					}
				}
				if(cnt == 5) {
					ans = "YES";
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		} //tc
	} //main
} //class