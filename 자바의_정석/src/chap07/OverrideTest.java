package chap07;

class Point3 extends Object{
	int x;
	int y;
	
	Point3(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//object class의 toString()을 오버라이딩
	public String toString() { // -> 오버라이딩해도 조상의 내용은 그대로. 조상 건 쓰이지 않음
		return "x :" + x + ", y: "+ y;
	}
}


//class Point3D extends Point3 { //3차원 좌표상의
//	int z; //점
//	
//	//조상의 getLocation()을 오버라이딩 -> 둘 중에 오버라이딩 된 것이 호출됨
//	String getLocation() {
//		return "x :" + x + ", y: "+ y + ", z: " + z;
//	}
//}


public class OverrideTest {
	public static void main(String[] args) {
		Point3 p = new Point3(3, 5);
//		p.x = 3;
//		p.y = 5;
		System.out.println(p);

//		System.out.println(p.toString());

	}
}
