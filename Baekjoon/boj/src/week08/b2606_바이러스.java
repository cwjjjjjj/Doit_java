package week08;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class b2606_바이러스 {
	
	static int[] p; //대표 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //정점(컴퓨터)의 개수
		int E = sc.nextInt(); //간선의 개수
		
		//간선 배열
		int[][] edges = new int[E][2];
		
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt(); //시작 정점
			edges[i][1] = sc.nextInt(); //끝 정점
		}
		
		p = new int[V+1];
		//make-set
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		//간선을 모두 union
		for (int i = 0; i < E; i++) {
				union(edges[i][0], edges[i][1]);
		}
		
		int cnt = 0;
		//find-set으로 동일 집합인지 검사
		for (int i = 1; i < V+1; i++) {
			if(findset(i) == findset(1)) {
				cnt++;
			}
		}
		if(cnt==1) {
			System.out.println(0);
		} else {
		System.out.println(cnt-1); //1번은 제외하고 뽑아야 함
		}
	}
	
	static void union(int x, int y) {
		if(p[x] < p[y]) { //트리 구조이기 때문에, 더 작은 값이 부모가 된다
			//패스 컴프레션(?)이 없어서 엉뚱한 값이 덮어씌워지고 있었음!!!!! 중요중요매우중요 빠뜨리지말기
			p[findset(y)] = findset(x);
		} else {
			p[findset(x)] = findset(y);
		}
	}
	
	static int findset(int x) { 
		if(x==p[x]) return x; //자신이 부모노드면 그대로 반환
		return findset(p[x]); //아니라면 재귀호출로 부모노드 찾음
	}
}