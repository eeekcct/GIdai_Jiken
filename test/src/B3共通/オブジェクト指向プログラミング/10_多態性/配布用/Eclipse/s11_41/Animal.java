package s11_41;

public class Animal {
	private int myType = 0;

	public Animal(int type) {
		myType = type;
	}

	public String cry() {
		if (myType == 0) {
			return "わんわん";
		} else {
			return "にゃんにゃん";
		}
	}

	public String eat() {
		if (myType == 0) {
			return "食べるわん";
		} else {
			return "食べるにゃん";
		}
	}

	public String attack() {
		if (myType == 0) {
			return "攻撃するわん";
		} else {
			return "攻撃するにゃん";
		}
	}

	public String run() {
		if (myType == 0) {
			return "走るわん";
		} else {
			return "走るにゃん";
		}
	}

	public String sleep() {
		if (myType == 0) {
			return "眠るわん";
		} else {
			return "眠るにゃん";
		}
	}
}
