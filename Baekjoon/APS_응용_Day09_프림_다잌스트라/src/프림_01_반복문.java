import java.util.Arrays;
import java.util.Scanner;

public class 프림_01_반복문 {
	static final int INF = Integer.MAX_VALUE; // 상수

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 7이 들어오는데, 0~6번 사용하므로 [V][V]
		int E = sc.nextInt();

		// 인접 행렬
		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) { //E를  V로 바꿔도 같은 값 출력됨
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			// 무향그래프니까
			adjArr[A][B] = W;
			adjArr[B][A] = W;
		} // 입력 완료

		// 정점은 뽑히거나, 안 뽑히거나 두 가지 상태에 있을 수 있으므로 boolean으로 관리
		boolean[] visited = new boolean[V];
		// 부모 정보는 필요 없는 경우도 많음

		int[] p = new int[V]; // 내가 어디에서 왔는지
		int[] dist = new int[V]; // key(값)을 저장하는 용도

		for (int i = 0; i < V; i++) {
			p[i] = -1;
			dist[i] = INF;
		} // 초기화

		Arrays.fill(dist, INF); // 이렇게 하면 반복문 안 써도 알아서 채워짐. 속도는 반복문보다 느림

		// 임의의 한 점을 선택해서 돌려야 한다. 굳이 중간에 있는 점 돌릴 필요 없음
		dist[0] = 0; // 가장 먼저 뽑히게 세팅
		int ans = 0;

		// 프림을 동작시키겠다
		for (int i = 0; i < V; i++) { // 마지막 정점에서는 더 이상 갈 수 있는 곳이 없으니까 V-1
			int min = INF; // 이 부분... 꼭 필요할까?
			int idx = -1;
			// 반복문을 순회하면서 아직 안 뽑은 친구들 중 가장 작은 값을 뽑겠다
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) { // 아직 방문하지 않았으면서 min보다 작으면 갱신
					min = dist[j];
					idx = j;
				}
			}
			// 위의 반복문이 끝났다
			// 니가 제일 작네? 인덱스 이제 알겠어
			visited[idx] = true; // 넌 뽑혔어
			ans += dist[idx];
			
			// 2. 뽑은 친구와 인접한 친구들 중 갱신할 수 있는 애들은 모조리 갱신
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) { // 방문 안 했고, 간선 있는지 확인
					dist[j] = adjArr[idx][j]; // 더 작으면 갱신
					p[j] = idx; // 부모 정보가 필요없으면 안 써도 됨
				}
			}
		}
//		for (int i = 0; i < V; i++) {
//			ans += dist[i];
//		}
		System.out.println(ans);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "\r\n";
}
