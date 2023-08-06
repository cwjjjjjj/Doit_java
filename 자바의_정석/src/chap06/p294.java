package chap06;

public class p294 {

}

class Car1 {
	String color;
	String gearType;
	int door;
	
	Car1() {}
	
	Car1 (String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}

class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color = "White";
		c1.gearType = "auto";
		c1.door = 4;
		
		Car c2 = new Car("White", "auto", 4);
		//c2처럼 매개변수가 있는 생성자를 사용해 초기화하는 것이 더 간결하고 직관적
	}
}