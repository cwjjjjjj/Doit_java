package chap07p357;

public class CastingTest {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe; //car = (Car)fe 에서 형변환 생략됨. 업캐스팅
//		car.water(); //컴파일 에러! Car 타입의 참조변수로는 water()를 호출할 수 X
		fe2 = (FireEngine)car; //형변환 생략불가. 다운캐스팅
		fe2.water();
	}
}