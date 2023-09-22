import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬_01_Queue {
	public static String[] cook = { "", "재료 구매", "양념장 만들기", "고기 재우기", "고기 손질", "제육볶음 만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// 인접행렬
		int[][] adjArr = new int[V + 1][V + 1]; // 문제에서 1번 정점부터 V번까지 사용하므로 +1
		int[] degree = new int[V + 1]; // 진입차수를 저장할 배열

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			// 유향이므로 A->B만 저장하면 됨
			adjArr[A][B] = 1; // 가중치가 주어지지 않았기 때문에 1로 저장
			// 진입차수를 증가시키기
			degree[B]++;
			// 왜 B인가? => A -> B 방향으로 감
		} // 입력 완료

		// 작업이 들어갈 Queue 준비. degree가 0인 것들만 들어갈 수 있음
		Queue<Integer> queue = new LinkedList<>();

		// 초기에 진입차수가 0인 선작업이 없는 친구들(재료구매, 밥하기, 양념장)을 몽땅 넣자
		for (int i = 0; i < V + 1; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int work = queue.poll(); // 지금 할 작업을 하나 꺼낸다. 꺼냈으면 작업을 한 거나 다름없음

			System.out.println(cook[work]); // 작업을 출력해보자
			for (int i = 0; i < V + 1; i++) {
				if (adjArr[work][i] == 1) { // 유향이므로 work - i라는 순서가 중요함!!
					adjArr[work][i] = 0; // 간선 제거 (안 넣어도 답은 나오지만 명확하게 하기 위해)
					degree[i]--; // 진입차수 감소

					// 진입차수가 0이 되었다는 것는 선행작업이 완료되었다는 것
					// 따라서 Queue에 들어갈 준비가 됨
					if (degree[i] == 0) {
						queue.add(i);
					}
				} // 연결 확인
			} // 연결 끊는 작업
		}
	}

	public static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n"
			+ "5 6\r\n" + "9 6\r\n" + "6 7\r\n" + "";
}