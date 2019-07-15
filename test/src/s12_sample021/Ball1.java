package s12_sample021;

public class Ball1 extends Character {
	public Ball1() {
		super(0,0,36,36);
		appearFlag=false;
	}

	public void fire(int bx,int by) {
		if (!appearFlag) {
			x = bx;
			y = by;
			ySpeed = 25;
			appearFlag = true;
		}
	}

	public void move() {
		if (appearFlag) {
			y += ySpeed;
			ySpeed -= 2;
			if (y < 0) {
				appearFlag = false;
			}
		}
	}
}
