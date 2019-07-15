package s12_sample021;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Sample12_021 extends GameBase {

	BufferedImage backImage;
	BufferedImage playerImage;
	BufferedImage ballImage;
	BufferedImage dogImage;

	Player1 player1;
	Player2 player2;
	Ball1 ball1;
	Ball2 ball2;

	public static void main(String[] args) {
		new Sample12_021();
	}

	protected void initialize() {
		// リソース（画像）の読み込み
		backImage = cg.loadImage("/img/sky01.jpg");
		playerImage = cg.loadImage("/img/player.png");
		ballImage = cg.loadImage("/img/ball.png");

		// オブジェクトの生成
		player1 = new Player1();
		player2 = new Player2();
		ball1 = new Ball1();
		ball2 = new Ball2();

		player1.setAppearFlag(true);
		player2.setAppearFlag(false);

		// オブジェクトの接続
		player1.setBall1(ball1);
		player1.setBall2(ball2);
		player2.setBall1(ball1);
		player2.setBall2(ball2);
	}

	protected void play() {
		// キー入力
		switch (key.getCode()) {
		case KeyEvent.VK_RIGHT:
			player1.turnRight();
			player2.turnRight();
			break;
		case KeyEvent.VK_LEFT:
			player1.turnLeft();
			player2.turnLeft();
			break;
		case KeyEvent.VK_SPACE:
			player1.fire();
			player2.fire();
			break;
		case KeyEvent.VK_1:
			player1.setMode(1);
			player2.setMode(1);
			break;
		case KeyEvent.VK_2:
			player1.setMode(2);
			player2.setMode(2);
			break;
		case KeyEvent.VK_3:
			break;
		case KeyEvent.VK_Z:
			player1.setAppearFlag(true);
			player2.setAppearFlag(false);
			break;
		case KeyEvent.VK_X:
			player1.setAppearFlag(false);
			player2.setAppearFlag(true);
			break;
		case KeyEvent.VK_C:
			break;
		default:
			player1.stop();
			player2.stop();
		}

		// move()
		player1.move();
		player2.move();
		ball1.move();
		ball2.move();

		// キャラクターの描画
		cg.drawImage(0,0,backImage);
		drawCharacter(player1,playerImage);
		drawCharacter(player2,playerImage);
		drawCharacter(ball1,ballImage);
		drawCharacter(ball2,ballImage);

	}

	private void drawCharacter(Character character,BufferedImage image) {
		if (character.isAppear()) {
			int x = character.getX();
			int y = character.getY();
			int xSize = character.getXsize();
			int ySize = character.getYsize();
			cg.drawImage(x,y,xSize,ySize,image);
		}
	}
}
