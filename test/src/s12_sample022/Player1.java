package s12_sample022;

public class Player1 extends Player{
	public Player1() {
		super(0,0,48,48);
	}

	private Ball myBall;

	public void setBall(Ball ball){
		myBall=ball;
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

	public void fire(){
		myBall.fire(x,y);
	}

	public void move() {
		x += xSpeed;
	}
}
