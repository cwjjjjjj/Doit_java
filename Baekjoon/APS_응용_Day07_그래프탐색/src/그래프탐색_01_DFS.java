
public class 그래프탐색_01_DFS {
	static int N = 7;
	//인접행렬 저장할 수 있어야 함
	static int[][] adj = { 
			{ 0, 1, 1, 0, 0, 1, 0 }, 
			{ 1, 0, 0, 1, 0, 0, 1 }, 
			{ 1, 0, 0, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 0, 0 }, 
			{ 0, 1, 0, 1, 1, 0, 0 } };
	
	//방문처리할 배열
	static boolean[] visited = new boolean[N];
	
	public static void main(String[] args) {
		//실제 문제를 푸는 경우에는 여기서 new 하는 것이 맞음
		DFS(0);
	}
	
	//인자로 현재 내가 방문하고 있는 정점이 들어온다
	static void DFS(int v) {
		//v에 대한 방문처리를 하겠다
		visited[v] = true;
		System.out.println(v+1); //교재랑 맞추기 위해 출력만 +1 한 거임
		
		//방문하지 않았으면서, 너와 내가 연결된 간선이 존재한다면 재귀 호출
		for(int i = 0; i < N; i++) { //N은 정점, 또는 adj.length도 가능
			if(!visited[i] && adj[v][i] == 1) //v = 내가 방문하고 있는 점. i는 나와 연결되어있는 체크하기 위해
				DFS(i);
		}
	}
}