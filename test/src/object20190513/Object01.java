package object20190513;

public class Object01 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] test = { 80, 60, 22, 50, 75 };

		for (int s = 0; s < test.length - 1; s++) {
			for (int t = s + 1; t < test.length; t++) {
				if (test[t] > test[s]) {
					int temp = test[t];
					test[t] = test[s];
					test[s] = temp;
				}
			}
		}

		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + "位は" + test[i] + "点です。");
		}
	}
}
