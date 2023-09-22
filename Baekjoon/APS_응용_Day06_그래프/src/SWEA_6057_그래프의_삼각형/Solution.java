package SWEA_6057_그래프의_삼각형;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_6057_그래프의_삼각형/input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //tc의 개수
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt() ; //정점의 개수
			int M = sc.nextInt() ; //간선의 개수
			//인접행렬
			int[][] adjArr = new int[N+1][N+1]; //인덱스 1번부터 사용함 //[N+1][M+1] 아님
			
			//간선의 정보 입력받음
			for(int i = 0; i < M; i++) { //간선의 개수만큼 반복
				int A = sc.nextInt(); //시작 정점
				int B = sc.nextInt(); //끝정점
				adjArr[A][B] = 1;
			} //2차원 배열 생성됨
			
			int cnt= 0;
			for(int i = 1; i <= N-2; i++) { //정점 1
				for(int j = i+1; j <= N-1; j++) { //정점 2
					for(int k =j+1; k <= N; k++) { //정점 3
						if(adjArr[i][j] == 1 && adjArr[i][k] == 1 && adjArr[j][k] == 1) {
							 cnt++;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}//tc
	} //main
}//class