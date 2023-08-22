package chap07;

abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	void stop() {
		System.out.println("멈춥니다");
	}
}

interface Fightable { //인터페이스의 모든 메서드는 예외없이 public abstract
	void move(int x, int y); //public abstract가 생략됨
	void attack(Fightable f); //public abstract가 생략됨
}

class Fighter extends Unit implements Fightable {
	public void move(int x, int y) { //오버라이딩 규칙: 조상(public)보다 접근제어자가 좁으면 안 됨
		System.out.println(x+", "+y+"로 이동");
	}
	public void attack(Fightable f) {
		System.out.println(f+"를 공격");
	}
}

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		f.move(100, 200);
		f.attack(new Fighter());
	}
}