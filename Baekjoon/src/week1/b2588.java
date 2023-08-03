package week1;

import java.util.Scanner;

public class b2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		int n = sc.nextInt();

//		int a = n/100; //100의자리수
//		int b = n-(100*a); //10의 자리수
//		int c = n -100*a -(10*b); //1의 자리수
		
		//1의 자리수
		int a = n%10; //5
		//10의 자리수
		int b =(((n-a)%100)/10); //8
		//100의 자리수
		int c = ((n-a-(b*10))%1000)/100; //3
		
		System.out.println(a*i);
		System.out.println(b*i);
		System.out.println(c*i);
		System.out.print(n*i);
	}
}