package week2;

import java.util.Scanner;

public class b2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//if만 쓰지 말고 else if, else 사용해서 줄여서 다시 써보기
		int prize = 0;
		
		if(a == b && a == c) {
			prize = 10000+(1000*a);
		}
		
		if(a == c && b != a) {
			prize = 1000+(100*a);
		}
		
		if(a == b && a != c) {
			prize = 1000+(100*a);

		}
		
		 if(b == c && a != c) {
			prize = 1000+(100*b);

		 }

		 int max = 0;
		 if (a != b && b != c && a != c) { //a != c가 빠져있었
			if(a>max)
				max = a;
			if(b>max)
				max = b;
			if(c>max)
				max = c;
			//Math.max(math.max, b) 로 구해보기
		
			prize = max*100;
		}
		 
		System.out.print(prize);
	}

}
