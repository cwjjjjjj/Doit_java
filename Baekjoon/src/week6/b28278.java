package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b28278 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //명령의 수
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			String o = br.readLine(); 
			if(o.equals("2")) {
				if(!stack.isEmpty()) {
					System.out.println(stack.pop());
				} else {
					System.out.println(-1);
				}
			} else if(o.equals("3")) {
				System.out.println(stack.size());
			} else if(o.equals("4")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(o.equals("5")) {
				if(!stack.isEmpty()) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
			} else {
				String tmp[] = o.split(" ");
				stack.push(Integer.parseInt(tmp[1]));
			}
		}
	}
}