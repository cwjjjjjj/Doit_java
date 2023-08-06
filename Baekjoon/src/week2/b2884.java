package week2;

import java.util.Scanner;

public class b2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if(M>=45) {
			int resultM = M-45;
			System.out.println(H+ " " +resultM);
		}
		else if(M<45 && H > 0) {
			int resultH = H-1;
			int resultM = M+60-45;
			System.out.println(resultH+ " " +resultM);
		}
		else if(M<45 && H <= 0) {
			int resultH = 23;
			int resultM = M+60-45;
			System.out.println(resultH+ " " +resultM);
		}
	}
}
