package game02;

public class Misile extends Character {
	private boolean activeFlag = false;
	private Player myPlayer;

	public Misile() {
		x = 300;
		y = 400;
		xSize = 20;
		ySize = 40;
	}

	public void setPlayer(Player player) {
		myPlayer = player;
	}

	public void setX(int mx) {
		x = mx;
	}

	public void setY(int my) {
		y = my;
	}

	public void move() {
		if (activeFlag == true) {
			y = y - 3;
			if (y < 0) {
				y = 400;
				activeFlag = false;
			}
		}
	}

	public void attack() {
		if (activeFlag == true) {
			int px = myPlayer.getX();
			int py = myPlayer.getY();
			int pxSize = myPlayer.getXSize();
			int pySize = myPlayer.getYSize();
			if (x <= px + pxSize && px <= x + xSize) {
				if (y <= py + pySize && py <= y + ySize) {
					myPlayer.dead();
					activeFlag = false;
				}
			}
		}
	}

	// ====================
	// フラグ
	// ====================
	public void active() {
		activeFlag = true;
	}

	public void notActive() {
		activeFlag = false;
	}

	public boolean isActive() {
		return activeFlag;
	}
}
