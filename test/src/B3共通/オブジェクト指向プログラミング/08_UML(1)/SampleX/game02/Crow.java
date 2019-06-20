package game02;

public class Crow extends Character{
	private Misile myMisile;
	private int xSpeed = 3;

	public Crow(){
		x=0;
		y=300;
		xSize=80;
		ySize=40;
	}

	public void setMisile(Misile misile){
		myMisile=misile;
	}

	public int getXSpeed(){
		return xSpeed;
	}

	public void move() {
		x = x + xSpeed;
		if (x < 0 || x > 600-xSize) {
			xSpeed = -xSpeed;
		}
	}

	public void fire(){
		if( myMisile.isActive()==false){
			myMisile.setX(x);
			myMisile.setY(y);
			myMisile.active();
		}
	}
}
