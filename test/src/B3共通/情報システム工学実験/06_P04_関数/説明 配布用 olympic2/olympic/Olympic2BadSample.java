package olympic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Olympic2BadSample {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("今年は西暦何年ですか？");
		String str = br.readLine();
		int year = Integer.parseInt(str);
		System.out.println("今は何月ですか？");
		str = br.readLine();
		int month = Integer.parseInt(str);
		if (year > 2020) {
			System.out.println("東京オリンピックはもう終わってます！！");
		} else if (year == 2020) {
			if (month == 7 || month == 8) {
				System.out.println("東京オリンピックは今月です！");
			} else if (month > 8) {
				System.out.println("東京オリンピックはもう終わってます！！");
			} else {
				System.out.println("東京オリンピックまで、あと" + (7 - month) + "カ月です");
			}
		} else {
			int leftYear = 2020 - year;
			if (month >= 8) {
				leftYear--;
			}
			int leftMonth = (19 - month) % 12;
			int totalMonth = leftYear * 12 + leftMonth;
			System.out.println("東京オリンピックまで、あと" + totalMonth + "ケ月です");
		}
	}
}
