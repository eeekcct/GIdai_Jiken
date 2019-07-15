package s12_sample022;

public class Player2 extends Player{
	public Player2() {
		super(0,0,48,48);
		ySpeed=10;
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
		y += ySpeed;
		ySpeed--;
		if( y<0){
			y=0;
			ySpeed=10;
		}
	}
}
