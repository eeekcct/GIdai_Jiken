package ex190509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SPX {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("正の整数を入力してください");
			String str = br.readLine();
			int num = Integer.parseInt(str);
			System.out.print(num+"=");
		}
}
