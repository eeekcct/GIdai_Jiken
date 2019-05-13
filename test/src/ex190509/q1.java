package ex190509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1 {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("今年は西暦何年ですか？");
			String str = br.readLine();
			int year = Integer.parseInt(str);

			if(year < 2020) System.out.println("東京オリンピックまで、あと"+(2020-year)+"です。");
			else if(year > 2020) System.out.println("東京オリンピックは終わりました。");
			else System.out.println("東京オリンピックは今年開催です。");
		}
}
