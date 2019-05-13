package ex190509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample01 {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("整数を入力してください。");
			String str = br.readLine();
			int num = Integer.parseInt(str);
			System.out.println("整数2を入力してください。");
			String str2 = br.readLine();
			int num2 = Integer.parseInt(str2);

			if(num == 1 && num2 == 3 ){
				System.out.println("1と3ですね");
			}
			else{
				System.out.println("1ではない");
			}
			System.out.println("以上！");
		}
}
