package week8;

import java.util.Scanner;

public class b17478 {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//제일 처음에만 오는 문장 -> ____필요없음
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		int N = sc.nextInt();
		answer(N);
		System.out.println(sb);
	}
	
	public static void answer (int n) {
		
		if(n==0) { //0회가 되면 종료
			sb.append("\"재귀함수가 뭔가요?\"\n");
			sb.append( "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append("라고 답변하였지.\n");
		} else {
			//중복 내용 출력
			sb.append("\"재귀함수가 뭔가요?\"\n");
			sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\n");
			answer(n-1); //재귀호출
			sb.append("라고 답변하였지.\n"); //마지막 문장 -> ____필요없음
		}
	}
	
	public static void bar(int b) {
		
	}
}