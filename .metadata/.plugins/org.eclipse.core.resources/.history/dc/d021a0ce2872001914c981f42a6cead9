package ex190509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2 {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("今年は西暦何年ですか？");
			String str = br.readLine();
			System.out.print("今年は何月ですか？");
			String str2 = br.readLine();
			
			int year = Integer.parseInt(str);
			int month = Integer.parseInt(str2);

			if(year < 2020 || (year == 2020 && month < 7)) {
				System.out.println("東京オリンピックまで、あと"+((2020-year)*12+(7-month))+"ヶ月です。");
			}
			else if(year > 2020 || month>8 ) System.out.println("東京オリンピックは終わりました。");
			else{
				System.out.println("東京オリンピックは今月です。");
			}
		}
}
