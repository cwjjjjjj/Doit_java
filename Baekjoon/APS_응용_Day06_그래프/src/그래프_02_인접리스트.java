import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정점의 개수(V)와 간선의 개수(E)가 주어진다
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		//인접리스트
		List<Integer>[] adjList = new ArrayList[V+1];
		
		for(int i = 0; i < V+1; i++) {
			adjList[i] = new ArrayList<>();
			//이렇게 넣지 않으면  nullPointerExceoption 뜬다
		}
		
		//간선의 정보를 입력받자
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt(); //시작 정점
			int B = sc.nextInt(); //끝정점
			int w = sc.nextInt(); //가중치 그래프라면 가중치 값
			
//			if(adjList[A]==null ) // 이렇게 해도 됨
			adjList[A].add(B); //유향 그래프라면 아랫줄 필요없음
			adjList[B].add(A); //무향 그래프라면 필수
		}
	}
}