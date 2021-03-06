package olympic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Olympic2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//gitのためのコメント
		System.out.println("今年は西暦何年ですか？");
		String strYear = br.readLine();
		int year = Integer.parseInt(strYear);

		System.out.println("今は何月ですか？");
		String strMonth = br.readLine();
		int month = Integer.parseInt(strMonth);

		if (eventIsBeingHeld(year, month)) {
			System.out.println("東京オリンピックは開催中です！");
		} else if (eventIsClosed(year, month)) {
			System.out.println("東京オリンピックはもう終わってます！！");
		} else {
			System.out.println("東京オリンピックまで、あと" + monthsToOpen(year, month) + "ケ月です。");
		}
	}

	public static boolean eventIsOpened(int year, int month) {
		return year>2020 || year == 2020 && month >= 7;
	}

	public static boolean eventIsClosed(int year, int month) {
	    return false;
	}

	public static boolean eventIsBeingHeld(int year, int month) {
	    return false;
	}

	public static int monthsToOpen(int year, int month) {
	    return 0;
	}
}
