package chap06;

public class p296 {

}

class Car {
	String color;
	String gearType;
	int door;
	
	Car() { //Car(String color, String gearType, int door)를 this를 사용해 호출
		this("white", "auto", 4);
		//생성자 Car()를 사용해서 Car인스턴스를 생성한 경우에, 인스턴스 변수 color는 white, gearType은 auto, door은 4로 초기회되도록 함
	}
	
	Car(String color) { //역할??
		this(color, "auto", 4);
	}
	
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

class CarTest2 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("blue");
		
		System.out.println("c1의 color=" +c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
		System.out.println("c2의 color=" +c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);
	}
}