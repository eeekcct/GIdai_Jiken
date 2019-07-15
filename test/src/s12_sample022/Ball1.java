package s12_sample022;

public class Ball1 extends Ball {
	public Ball1() {
		super(0,0,36,36);
		appearFlag=false;
	}

	public void fire(int bx,int by) {
		if (!appearFlag) {
			appearFlag = true;
			x = bx;
			y = by;
			ySpeed = 25;
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
