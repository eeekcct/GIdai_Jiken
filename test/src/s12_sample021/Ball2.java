package s12_sample021;

public class Ball2 extends Character {
	public Ball2() {
		super(0,0,36,36);
		appearFlag=false;
	}

	public void fire(int bx,int by) {
		if (!appearFlag) {
			x = bx;
			y = by;
			ySpeed = 25;
			xSpeed = 10;
			appearFlag = true;
		}
	}

	public void move() {
		if (appearFlag) {
			x += xSpeed;
			y += ySpeed;
			ySpeed -= 2;
			if (y < 0) {
				appearFlag = false;
			}
		}
	}
}
