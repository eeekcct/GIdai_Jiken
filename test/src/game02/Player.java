package game02;

public class Player extends Character{
	private Princess myPrincess;

	private int ySpeed = 0;

	private int hp = 200;

	private boolean jumpFlag = false;
	private boolean deadFlag = false;

	public Player(){
		x=100;
		y=20;
		xSize=48;
		ySize=48;
	}

	public void setPrincess(Princess princess) {
		myPrincess = princess;
	}

	public int getHp() {
		return hp;
	}

	public void goRight() {
		x = x + 3;
	}

	public void goLeft() {
		x = x - 3;
	}

	public void move() {
		if (jumpFlag == true) {
			ySpeed = ySpeed - 2;
			y = y + ySpeed;
			if (y < 20) {
				y = 20;
				jumpFlag = false;
			}
		}
	}

	public void rescue() {
		int princessX = myPrincess.getX();
		if (princessX < x) {
			myPrincess.rescue();
		}
	}

	// ====================
	// フラグ
	// ====================
	public void jump() {
		if (jumpFlag == false) {
			jumpFlag = true;
			ySpeed = 20;
		}
	}

	public void notJump() {
		jumpFlag = false;
		ySpeed = 0;
	}

	public boolean isJump() {
		return jumpFlag;
	}

	public void dead() {
		deadFlag = true;
	}

	public void notDead() {
		deadFlag = false;
	}

	public boolean isDead() {
		return deadFlag;
	}
}
