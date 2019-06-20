package game02;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class Game02 extends GameBase {

	public static void main(String[] args) {
		new Game02();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage playerImage;
	BufferedImage crowRightImage;
	BufferedImage crowLeftImage;
	BufferedImage princessImage;
	BufferedImage deathValleyImage;
	BufferedImage misileImage;

	// Model 変数定義
	Player player;
	MovingHole movingHole;
	Crow crow;
	Princess princess;
	DeathValley deathValley;
	Misile misile;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sky.jpg");
		playerImage = cg.loadImage("/img/player.png");
		crowRightImage = cg.loadImage("/img/crow_right.png");
		crowLeftImage = cg.loadImage("/img/crow_left.png");
		princessImage = cg.loadImage("/img/princess.png");
		deathValleyImage = cg.loadImage("/img/valley.jpg");
		misileImage = cg.loadImage("/img/misile.png");

		// Model オブジェクト生成
		player = new Player();
		movingHole = new MovingHole();
		crow=new Crow();
		princess=new Princess();
		deathValley=new DeathValley();
		misile=new Misile();

		// Model オブジェクト関連付け
		player.setPrincess(princess);
		deathValley.setPlayer(player);
		misile.setPlayer(player);
		crow.setMisile(misile);
	}

	public void play() {
		// View キー入力
		if (key.isPress(KeyEvent.VK_RIGHT)) {
			player.goRight();
		}
		if (key.isPress(KeyEvent.VK_LEFT)) {
			player.goLeft();
		}
		if (key.isPress(KeyEvent.VK_SPACE)) {
			player.jump();
		}

		// Model 動作
		movingHole.move();
		crow.move();
		crow.fire();
		misile.move();
		misile.attack();
		deathValley.attack();
		player.move();
		player.rescue();

		// View 画面表示
		drawView();
	}

	private void drawView() {
		drawBack();

		drawGround();
		drawMovingHole();

		drawCrow();
		drawMisile();
		drawDeathValley();
		drawPrincess();

		drawPlayer();
		drawHitPoint();
		if( player.isDead() ){
			drawGameOver();
		}else if( princess.isRescue() ){
			drawGameClear();
		}
	}

	private void drawBack() {
		cg.drawImage(0, 0, backImage);
	}

	private void drawGround() {
		cg.setColor(new Color(75, 35, 25));
		cg.fillRect(0, 0, 620, 20);
	}

	private void drawMovingHole() {
		int mhx = movingHole.getX();
		int mhy = movingHole.getY();
		int mhxSize = movingHole.getXSize();
		int mhySize = movingHole.getYSize();
		cg.setColor(new Color(255, 255, 255));
		cg.fillRect(mhx,mhy,mhxSize, mhySize);
	}

	private void drawCrow() {
		int cx = crow.getX();
		int cy = crow.getY();
		int cxSize = crow.getXSize();
		int cySize = crow.getYSize();
		int cxSpeed= crow.getXSpeed();
		if( cxSpeed > 0){
			cg.drawImage(cx, cy, cxSize, cySize,crowRightImage);
		}else{
			cg.drawImage(cx, cy, cxSize, cySize,crowLeftImage);
		}
	}

	private void drawPrincess() {
		int rx = princess.getX();
		int ry = princess.getY();
		int rxSize = princess.getXSize();
		int rySize = princess.getYSize();
		cg.drawImage(rx, ry, rxSize, rySize, princessImage);
	}

	private void drawDeathValley() {
		int vx = deathValley.getX();
		int vy = deathValley.getY();
		int vxSize = deathValley.getXSize();
		int vySize = deathValley.getYSize();
		cg.drawImage(vx, vy, vxSize, vySize, deathValleyImage);
	}

	private void drawMisile() {
		int mx = misile.getX();
		int my = misile.getY();
		int mxSize = misile.getXSize();
		int mySize = misile.getYSize();
		cg.drawImage(mx, my, mxSize, mySize, misileImage);
	}

	private void drawPlayer() {
		int px = player.getX();
		int py = player.getY();
		int pxSize = player.getXSize();
		int pySize = player.getYSize();
		cg.drawImage(px, py, pxSize, pySize, playerImage);
	}

	private void drawHitPoint() {
		int php = player.getHp();
		cg.setColor(Color.BLUE);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 18));
		cg.drawStringRight(550, 360, "HP");
		cg.drawStringRight(595, 360, "" + php);
	}

	private void drawGameClear() {
		cg.setColor(Color.BLUE);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
		cg.drawStringCenter(300, 200, "Game Clear !!");
	}

	private void drawGameOver() {
		cg.setColor(Color.RED);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
		cg.drawStringCenter(300, 200, "Game Over !!");
	}

}
