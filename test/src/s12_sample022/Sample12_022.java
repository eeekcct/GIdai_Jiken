package s12_sample022;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Sample12_022 extends GameBase {

	BufferedImage backImage;
	BufferedImage playerImage;
	BufferedImage ballImage;
	BufferedImage dogImage;
	Player player;
	Ball ball;

	public static void main(String[] args) {
		new Sample12_022();
	}

	protected void initialize() {
		// リソース（画像）の読み込み
		backImage = cg.loadImage("/img/sky01.jpg");
		playerImage = cg.loadImage("/img/player.png");
		ballImage = cg.loadImage("/img/ball.png");

		// オブジェクトの生成
		player = new Player1();
		ball = new Ball1();

		// オブジェクトの連携
		player.setBall(ball);
	}

	protected void play() {
		// キー入力
		switch (key.getCode()) {
		case KeyEvent.VK_RIGHT:
			player.turnRight();
			break;
		case KeyEvent.VK_LEFT:
			player.turnLeft();
			break;
		case KeyEvent.VK_SPACE:
			player.fire();
			break;
		case KeyEvent.VK_1:
			ball = new Ball1();
			player.setBall(ball);
			break;
		case KeyEvent.VK_2:
			ball = new Ball2();
			player.setBall(ball);
			break;
		case KeyEvent.VK_3:
			break;
		case KeyEvent.VK_Z:
			player = new Player1();
			player.setBall(ball);
			break;
		case KeyEvent.VK_X:
			player = new Player2();
			player.setBall(ball);
			break;
		default:
			player.stop();
		}

		// キャラクタのmove()
		player.move();
		ball.move();

		// キャラクタの描画
		cg.drawImage(0, 0, backImage);
		drawCharacter(player, playerImage);
		drawCharacter(ball, ballImage);
	}

	private void drawCharacter(Character character, BufferedImage image) {
		if (character.isAppear()) {
			int x = character.getX();
			int y = character.getY();
			int xSize = character.getXsize();
			int ySize = character.getYsize();
			cg.drawImage(x, y, xSize, ySize, image);
		}
	}
}
