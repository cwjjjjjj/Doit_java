package SWEA_1251_하나로_크루스칼;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Edge {
	int st;
	int ed;
	double dist;

	public Edge(int st, int ed, double dist) {
		super();
		this.st = st;
		this.ed = ed;
		this.dist = dist;
	}
}

public class Solution {

	static int[] p; // 대표를 저장할 배열

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1251_하나로_크루스칼/input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc의 개수
		for (int tc = 1; tc <= 20; tc++) {
			int V = sc.nextInt(); // 섬(간선) 개수
			
			int[][] location = new int[V + 1][2]; // [0]: x 좌표, [1]: y 좌표 => 가중치를 구하기 위함
			for (int i = 0; i < V; i++) { // x 좌표
				location[i][0] = sc.nextInt();
			}
			
			for (int i = 0; i < V; i++) { // y 좌표
				location[i][1] = sc.nextInt();
			}

			double E = sc.nextDouble(); //세율
			
			int possibleEdge = V * (V - 1) / 2; // 생성 가능한 간선의 개수
			Edge[] edges = new Edge[possibleEdge]; //Edge를 V개 담는 배열 edges

			int idx = 0;
			for (int i = 0; i < V -1 ; i++) {
				for (int j = i+1; j < V ; j++) {
					double w = Math.sqrt(Math.pow(location[i][0] - location[j][0], 2)
					+ Math.pow(location[i][1] - location[j][1], 2));
					edges[idx++] = new Edge(i, j, w);
				}
			}

			// 크루스칼 1단계: 간선을 오름차순 정렬
			 Arrays.sort(edges, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
//					return o1.dist - o2.dist; // int형일때 비교하는 방법 1
//					return Integer.compare(o1.dist, o2.dist); // int 형 비교하는 방법 2
					return Double.compare(o1.dist,o2.dist);	// double형 비교하는 방법 -> 음수값 비교하기 위해 필요
				}
				});

			//크루스칼 2단계: V-1개의 간선을 뽑아야 하는데, 사이클이 생기지 않도록 뽑음 
			p = new int[V];
			
			//2-1. make-set
			for (int i = 0; i < V; i++) {
				p[i] = i;
			}
			
			//2-2. 검사하면서 뽑기
			double ans = 0; //최소비용
			int pick = 0; //뽑은 간선의 수

			for (int i = 0; i < possibleEdge; i++) { //내가 뽑은 pick이 V-1개가 되면 break 걸기
				//i번째 간선 이용해 두 개의 정점 가지고 처리하기
				int a = edges[i].st; //정점의 시작
				int b = edges[i].ed; //정점의 끝
				
				int pa = findset(a); //a의 대표
				int pb = findset(b); 
				
				if(pa != pb) { //사이클이 형성되지 않은 경우
					union(pa, pb);
					ans += (E * Math.pow(edges[i].dist, 2));
					pick++;
				}
				
				if(pick == V-1)	break;
			}
			
			//환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
			System.out.println("#"+tc+" "+Math.round(ans));
		} // tc
	} // main

	static void union(int x, int y) {
		p[y] = x;
	}

	static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
} // class