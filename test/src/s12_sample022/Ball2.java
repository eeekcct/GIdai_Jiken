package s12_sample022;

public class Ball2 extends Ball{
	public Ball2() {
		super(0,0,36,36);
		appearFlag=false;
	}

	public void fire(int bx,int by) {
		if (!appearFlag) {
			appearFlag = true;
			x = bx;
			y = by;
			ySpeed = 25;
			xSpeed = 10;
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
