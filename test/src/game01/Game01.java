package game01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class Game01 extends GameBase {

	public static void main(String[] args) {
		new Game01();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage playerImage;

	// Model 変数定義
	Player player;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sky.jpg");
		playerImage = cg.loadImage("/img/player.png");

		// Model オブジェクト生成
		player = new Player();

	}

	public void play() {
		// View キー入力
		if (key.isPress(KeyEvent.VK_RIGHT)) {
			player.goRight();
		}
		if (key.isPress(KeyEvent.VK_LEFT)) {
			player.goLeft();
		}

		// Model 動作


		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);

		// 地面表示
		cg.setColor(new Color(75, 35, 25));
		cg.fillRect(0, 0, 620, 20);

		// Player表示
		int px = player.getX();
		int py = player.getY();
		int pxSize = player.getXSize();
		int pySize = player.getYSize();
		cg.drawImage(px, py, pxSize, pySize, playerImage);

		// HitPoint表示
		int php = player.getHp();
		cg.setColor(Color.BLUE);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 18));
		cg.drawStringRight(550, 360, "HP");
		cg.drawStringRight(595, 360, "" + php);
	}
}
