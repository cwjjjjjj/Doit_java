import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class 프림_02_우선순위큐 {
	
	static final int INF = Integer.MAX_VALUE;
	
	//내가 만든 클래스 이용해서 우선순위큐 활용하려면 정렬기준이 필요함
	static class Edge implements Comparable<Edge>{ //나에 대한 정보
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			super();
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) { //비교할 친구
//			return this.w - o.w;
			return Integer.compare(this.w, o.w); //음수든 양이든 0이든 알아서 해줌
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		//인접 리스트
		List<Edge>[] adjList = new ArrayList[V];
		
		//리스트 생성
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
			
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjList[A].add(new Edge(A, B, W));
			adjList[B].add(new Edge(B, A, W));
		} //입력 끝
		
		//방문처리를 하기 위해서
		boolean[] visited = new boolean[V];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//시작정점을 하나 뽑고 넣어놓고 시작하겠다
		visited[0] = true;
		
		//정점을 하나 골라서 해당 정점의 모든 간선을 큐에 넣을 것임
		//제일 처음 뽑은 정점은 이미 뽑은 걸로 치자
		
		//세 가지 방법이 있음
//		for (int i = 0; i < adjList[0].size(); i++) {
//			pq.add(adjList[0].get(i)); //Edge를 pq에 넣겠다
//		}
//		
//		for (Edge e : adjList[0]) {
//			pq.add(e);
//		}
		
		pq.addAll(adjList[0]);
		
		int pick = 1; //이미 정점을 하나 뽑았으니
		int ans = 0;
		
		while(pick != V) {
			Edge e = pq.poll();
			
			if(visited[e.ed]) continue; //그냥 모조리 다 넣어버렸기 때문에 필요함
			ans += e.w;
			pq.addAll(adjList[e.ed]);
			visited [e.ed] = true;
			pick++;
		} 
		System.out.println(ans);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "\r\n";
}
