package s12_sample022;

public class Ball3 extends Ball2  {
	public void move() {
		if (appearFlag) {
			x += xSpeed;
			y += ySpeed;
			if (ySpeed < 0) {
				xSpeed = 0;
			}
			ySpeed -= 2;
			if (y < 0) {
				appearFlag = false;
			}
		}
	}

}
