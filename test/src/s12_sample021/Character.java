package s12_sample021;

public class Character {
	protected int x = 0;
	protected int y = 0;
	protected int xSize = 48;
	protected int ySize = 48;
	protected int xSpeed = 0;
	protected int ySpeed = 0;

	protected boolean appearFlag = true;

	// ======================
	// コンストラクタ
	// ======================
	public Character(int cx, int cy, int cxSize, int cySize) {
		x = cx;
		y = cy;
		xSize = cxSize;
		ySize = cySize;
	}

	// ======================
	// getter, setter
	// ======================
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXsize() {
		return xSize;
	}

	public int getYsize() {
		return ySize;
	}

	public int getXspeed() {
		return xSpeed;
	}

	public int getYspeed() {
		return ySpeed;
	}

	public boolean isAppear() {
		return appearFlag;
	}

	public void setX(int cx) {
		x = cx;
	}

	public void setY(int cy) {
		y = cy;
	}

	public void setXsize(int cxSize) {
		xSize = cxSize;
	}

	public void setYsize(int cySize) {
		ySize = cySize;
	}

	public void setXspeed(int cxSpeed) {
		xSpeed = cxSpeed;
	}

	public void setYspeed(int cySpeed) {
		ySpeed = cySpeed;
	}

	public void setAppearFlag(boolean cappearFlag) {
		appearFlag = cappearFlag;
	}

	// ======================
	// 位置情報取得・設定
	// ======================
	public int getLeft() {
		return x;
	}

	public int getRight() {
		return x + xSize - 1;
	}

	public int getTop() {
		return y + ySize - 1;
	}

	public int getBottom() {
		return y;
	}

	public int getCenterX() {
		return x + xSize / 2;
	}

	public int getCenterY() {
		return y + ySize / 2;
	}

	public void setLeft(int newLeft) {
		x = newLeft;
	}

	public void setRight(int newRight) {
		x = newRight + 1 - xSize;
	}

	public void setTop(int newTop) {
		y = newTop + 1 - ySize;
	}

	public void setBottom(int newBottom) {
		y = newBottom;
	}

	public void setCenterX(int newCenter) {
		x = newCenter - xSize / 2;
	}

	public void setCenterY(int newCenter) {
		y = newCenter - ySize / 2;
	}

	// ======================
	// 衝突判定
	// ======================
	public boolean overlapX(Character c) {
		if (getRight() < c.getLeft()) {
			return false;
		}
		if (c.getRight() < getLeft()) {
			return false;
		}
		return true;
	}

	public boolean overlapY(Character c) {
		if (getTop() < c.getBottom()) {
			return false;
		}
		if (c.getTop() < getBottom()) {
			return false;
		}
		return true;
	}

	public boolean overlapWith(Character c) {
		return overlapX(c) && overlapY(c);
	}

	// ========================
	// 衝突してきた方向の判定
	// ========================
	public boolean overlapFromTopWith(Character c) {
		double tRight = getRightOverlapTime(c);
		double tLeft = getLeftOverlapTime(c);
		double tTop = getTopOverlapTime(c);
		double tBottom = getBottomOverlapTime(c);

		// 過去に侵入 or 貫通済み
		if (tBottom < 0 || tTop < 0) {
			return false;
		}
		if (tRight < 0 && tLeft < 0) {
			return false;
		}

		// 未来の衝突
		if (1 < tTop) {
			return false;
		}

		// 右上から衝突
		if (tRight <= tTop && tTop < tLeft) {
			return true;
		}

		// 左上から衝突
		if (tLeft <= tTop && tTop < tRight) {
			return true;
		}

		return false;
	}

	public boolean overlapFromBottomWith(Character c) {
		double tRight = getRightOverlapTime(c);
		double tLeft = getLeftOverlapTime(c);
		double tTop = getTopOverlapTime(c);
		double tBottom = getBottomOverlapTime(c);

		// 過去に侵入 or 貫通済み
		if (tBottom < 0 || tTop < 0) {
			return false;
		}
		if (tRight < 0 && tLeft < 0) {
			return false;
		}

		// 未来の衝突
		if (1 < tBottom) {
			return false;
		}

		// 右下から衝突
		if (tRight <= tBottom && tBottom < tLeft) {
			return true;
		}

		// 左下から衝突
		if (tLeft <= tBottom && tBottom < tRight) {
			return true;
		}

		return false;
	}

	public boolean overlapFromLeftWith(Character c) {
		double tRight = getRightOverlapTime(c);
		double tLeft = getLeftOverlapTime(c);
		double tTop = getTopOverlapTime(c);
		double tBottom = getBottomOverlapTime(c);

		// 過去に侵入 or 貫通済み
		if (tRight < 0 || tLeft < 0) {
			return false;
		}
		if (tTop < 0 && tBottom < 0) {
			return false;
		}

		// 未来の衝突
		if (1 < tLeft) {
			return false;
		}

		// 左上から衝突
		if (tTop <= tLeft && tLeft < tBottom) {
			return true;
		}

		// 左下から衝突
		if (tBottom <= tLeft && tLeft < tTop) {
			return true;
		}

		return false;
	}

	public boolean overlapFromRightWith(Character c) {
		double tRight = getRightOverlapTime(c);
		double tLeft = getLeftOverlapTime(c);
		double tTop = getTopOverlapTime(c);
		double tBottom = getBottomOverlapTime(c);

		// 過去に侵入 or 貫通済み
		if (tRight < 0 || tLeft < 0) {
			return false;
		}
		if (tTop < 0 && tBottom < 0) {
			return false;
		}

		// 未来の衝突
		if (1 < tRight) {
			return false;
		}

		// 右上から衝突
		if (tTop <= tRight && tRight < tBottom) {
			return true;
		}

		// 右下から衝突
		if (tBottom <= tRight && tRight < tTop) {
			return true;
		}

		return false;
	}

	// ============================
	// 衝突してきた相手を押し返す
	// ============================
	public void pushLeft(Character c) {
		if (getLeft() <= c.getRight()) {
			c.setRight(getLeft() - 1);
		}
	}

	public void pushRight(Character c) {
		if (c.getLeft() <= getRight()) {
			c.setLeft(getRight() + 1);
		}
	}

	public void pushBottom(Character c) {
		if (getBottom() <= c.getTop()) {
			c.setTop(getBottom() - 1);
		}
	}

	public void pushTop(Character c) {
		if (c.getBottom() <= getTop()) {
			c.setBottom(getTop() + 1);
		}
	}

	// /////////////////////////////////////////
	// 内部計算用
	// /////////////////////////////////////////
	private int getOldTop() {
		return getTop() - ySpeed;
	}

	private int getOldBottom() {
		return getBottom() - ySpeed;
	}

	private int getOldLeft() {
		return getLeft() - xSpeed;
	}

	private int getOldRight() {
		return getRight() - xSpeed;
	}

	// 自分の右辺が相手の左辺と一致する時刻
	private double getRightOverlapTime(Character c) {
		// 相手の相対速度
		int rxs = c.xSpeed - xSpeed;

		// 移動していなければ∞
		if (rxs == 0) {
			return 1000;
		}

		// 相対位置/相対速度
		return (getRight() - c.getOldLeft() + 0.0) / rxs;
	}

	// 自分の左辺が相手の右辺と一致する時刻
	private double getLeftOverlapTime(Character c) {
		// 相手の相対速度
		int rxs = c.xSpeed - xSpeed;

		// 移動していなければ∞か-∞
		if (rxs == 0) {
			if (overlapX(c)) {
				return -1000;
			} else {
				return 1000;
			}
		}

		// 相対位置/相対速度
		return (getLeft() - c.getOldRight() + 0.0) / rxs;
	}

	// 自分の上辺が相手の下辺と一致する時刻
	private double getTopOverlapTime(Character c) {
		// 相手の相対速度
		int rys = c.ySpeed - ySpeed;

		// 移動していなければ∞
		if (rys == 0) {
			return 1000;
		}

		// 相対位置/相対速度
		return (getTop() - c.getOldBottom() + 0.0) / rys;
	}

	// 自分の下辺が相手の上辺と一致する時刻
	private double getBottomOverlapTime(Character c) {
		// 相手の相対速度
		int rys = c.ySpeed - ySpeed;

		// 移動していなければ∞か-∞
		if (rys == 0) {
			if (overlapY(c)) {
				return -1000;
			} else {
				return 1000;
			}
		}

		// 相対位置/相対速度
		return (getBottom() - c.getOldTop() + 0.0) / rys;
	}
}
