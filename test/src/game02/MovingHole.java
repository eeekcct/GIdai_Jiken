package game02;

public class MovingHole extends Character{

	public MovingHole(){
		x=580;
		y=5;
		xSize=15;
		ySize=15;
	}

	public void move() {
		x = x - 2;
		if (x < 0) {
			x = 600;
		}
	}
}
