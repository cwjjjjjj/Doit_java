package SWEA_1267_작업순서_큐;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1267_작업순서_큐/input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			System.out.print("#"+tc+" ");

			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수

			int[][] adjArr = new int[V + 1][V + 1]; // 문제에서 정점 1번부터 사용함
			int[] degree = new int[V + 1]; // 진입차수 저장할 배열

			for (int i = 0; i < E; i++) { // 간선 개수만큼 돌면서 정보 입력
				int A = sc.nextInt(); // 간선 시작점
				int B = sc.nextInt(); // 간선 끝점

				adjArr[A][B] = 1; // 가중치가 주어지지 않았으므로 1로 저장
				degree[B]++;
			} //입력 완료
			
			//작업이 들어간 Queue 준비 . degree가 0인 것들만 들어갈 수 있음
			Queue<Integer> queue = new LinkedList<>(); 
			
			//초기에 진입차수가 0인, 선작업이 없는 정점들 모두 넣기
			for (int i = 0; i < V + 1; i++) {
				if(degree[i] == 0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int work = queue.poll(); //지금 할 작업 하나 꺼내기
				if(work != 0) {
					System.out.printf(work+" ");
				}
				
				for (int i = 0; i < V + 1; i++) {
					if(adjArr[work][i] == 1) {
						adjArr[work][i] = 0;
						degree[i]--;
						
						//진입차수가 0이면 선행작업 완료되었다는 뜻 -> queue 에 넣기
						if(degree[i]==0) {
							queue.add(i);
						}
					}
				}
			}
			System.out.println();
		} // tc
	}// main
}// class
