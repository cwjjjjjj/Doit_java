package chap06;

public class p285 {
		//오버로딩: 이름은 같고 매개변수의 타입이나 개수가 다름
	
	int add(int a, int b) {
		return a+b;
		}
	
	long add(long a, long b) {
		return a+b;
		}
	
	long add(int[] a) { //배열의 모든 요소의 합을 반환한다
		long result = 0;
		
		for (int i=0; i<a.length; i++) {
			result += a[i];
		}
		return result;
	}
}