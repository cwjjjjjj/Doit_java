package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1406 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		sb.append(br.readLine()); //N길이의 문자열
		for(int i = 0; i < sb.length(); i++) { //N번 돌면서 왼쪽 배열에 넣기
			stack1.push(sb.charAt(i));
		}
		
		int M = br.read(); //명령어의 개수 M
		for(int i = 1; i <= M; i++) { //M번 돌면서 명령 수행
			String order = br.readLine();
			if(order.equals("L") ) {
				if(!stack1.isEmpty()) {
					stack2.push(stack1.pop()); //1에서 하나 빼서 2로 옮김
				}
			} else if(order.equals("D") ) {
				if(!stack2.isEmpty()) {
					stack1.push(stack2.pop()); //2에서 하나 빼서 1로 옮김
				}
			}else if(order.equals("B") ) {
				if(!stack1.isEmpty()) {
					stack1.pop(); //1에서 하나 삭제
				}
			} else { //P라면
//				String tmp[] = order.split(" ");
				stack1.push(order.charAt(2));
			}
		}
		br.close();
		//하나의 스택으로 합하기
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		for(int i = 0; i < stack2.size(); i++) {
			sb.append(stack2.pop());
		}
		System.out.print(sb);
	}
}