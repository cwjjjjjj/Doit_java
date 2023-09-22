import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 크루스칼_01 {
	
	static int[] p; //대표를 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		 int V = sc.nextInt(); //정점의 개수. 0부터 시작한다
		 int E = sc.nextInt(); //간선의 수
		 
		 //간선배열을 만들어서 저장할 것임. (사용자 정의 클래스 / 또는 2차원 배열로)
		 //2차원 배열 이용해서 만들어보자 ([0]: 시작 정점, [1]: 끝 정점, [2]: 가중치)
		 int[][] edges = new int[E][3];
		 
		 for(int i = 0; i < E; i++) {
			 edges[i][0] = sc.nextInt();
			 edges[i][1] = sc.nextInt();
			 edges[i][2] = sc.nextInt();
		 } //입력 끝
		 //간선이 주어지지 않으면 좌표를 이용해 만들어서 넣어야 함
		 
		 //크루스칼 1단계: 간선을 정렬(오름차순)
		 Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2]; //가중치를 이용해 오름차순으로 비교하게 됨
			}
		 }); //Comparator 쓰는 법 숙지하기
		
//		for(int[] e : edges) {
//			System.out.println(Arrays.toString(e));
//		} //정렬되었는지 확인하기 위해 출력
		 
		 //크루스탈 2단계: V-1개의 간선을 뽑아야 하는데, 사이클이 발생하지 않도록 뽑아
		 p = new int [V];
		 //2-1. make-set 하자
		 for(int i = 0; i < V; i++) {
//			 makeset(i); //메서드 호출 자체가 메모리, 시간 소모하므로 아랫줄이 더 효울적임
			 p[i] = i;
		 }
		 
		 //2-2. 검사하면서 뽑아
		 int ans = 0; //최소 비용을 저장할 친구
		 int pick = 0; //뽑은 간선의 수를 저장할 친구
		 
		 //while를 쓰려면 edges 배열을 돌릴 index 변수가 하나 필요하다
		 //for문을 쓰려면  if 문을 통해 break를 걸어줘야겠다 (이거로 해보자)
		 
		 for(int i = 0; i < E; i++) { //내가 뽑은 pick이 V-1개가 되면 break 걸기
			 //i번째 간선 이용하여 두 개의 정점을 가지고 처리하겠다
			 int x = edges[i][0];
			 int y = edges[i][1];
			 
			 int px = findset(edges[i][0]);
			 int py = findset(edges[i][1]);
			 
//			 if(findset(x) != findset(y)) {
			 if(px != py) {
				  //여기에 들어왔다는 건 사이클이 형성되지 않는다는 뜻
//				 union(x, y); //union해서 이번 간선 뽑았음
				 union(px, py);
				 ans += edges[i][2]; //edge의 i번째 간선에 2번 인덱스 추가하고.
				 pick++; //pick 증가시킴
			 }
			 
			 if(pick == V-1) break;
		 }
		 System.out.println(ans);
	}//main
	
	static void union(int x, int y) {
//		p[findset(y)] = findset(x); //x의 대표를 y위 대표로 넣겠다. rank 고려하지 않음
		p[y] = x; //하지만 이렇게 작성하는 것은 문제를 잘 이해했고 확신이 있을 때만 가능!
	}
	
	static int findset(int x) {
		//효율성 고려하지 않고 작성됨
//		if(x == p[x]) return x;
//		return findset(p[x]);
		
		//패스 컴프레션
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static void makeset(int i) {
		p[i] = i;
		//rank는 고려하지 않겠다
	}
	
	static String input = "7 11\r\n" + 
						"0 1 32\r\n" + 
						"0 2 31\r\n" + 
						"0 5 60\r\n" + 
						"0 6 51\r\n" + 
						"1 2 21\r\n" + 
						"2 4 46\r\n" + 
						"2 6 25\r\n" + 
						"3 4 34\r\n" + 
						"3 5 18\r\n" + 
						"4 5 40\r\n" + 
						"4 6 51\r\n" + 
						"\r\n";
} //class