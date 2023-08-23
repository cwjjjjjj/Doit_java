package chap07;

public class p410 {

}

class InnerEx6{
	Object iv = new Object() {void methpd() {} }; //익명 클래스
	static Object cv = new Object() { void method() {} }; //익명 클래스
	
	void myMehtod() {
		Object lv = new Object () { void method() {} }; 
	}
}