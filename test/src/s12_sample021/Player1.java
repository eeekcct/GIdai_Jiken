package s12_sample021;

public class Player1 extends Character {
	public Player1() {
		super(0, 0, 48, 48);
	}

	private Ball1 ball1;
	private Ball2 ball2;
	private Ball3 ball3;
	private int mode = 1;

	public void setBall1(Ball1 ball) {
		ball1 = ball;
	}

	public void setBall2(Ball2 ball) {
		ball2 = ball;
	}

	public void setBall3(Ball3 ball) {
		ball3 = ball;
	}


	public void setMode(int mode){
		this.mode=mode;
	}

	public void turnRight() {
		xSpeed = 5;
	}

	public void turnLeft() {
		xSpeed = -5;
	}

	public void stop() {
		xSpeed = 0;
	}

	public void fire() {
		switch(mode) {
		case 1:
			ball1.fire(x, y);
			break;
		case 2:
			ball2.fire(x, y);
			break;
		case 3:
			ball3.fire(x, y);
			break;
		}
	}

	public void move() {
		x += xSpeed;
	}
}
