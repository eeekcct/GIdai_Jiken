package s11_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample11_41 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("犬or猫（犬=0、猫=1）？");
		String str = br.readLine();
		int num = Integer.parseInt(str);

		if (num == 0) {
			System.out.println("わんわん");
			System.out.println("食べるわん");
			System.out.println("攻撃するわん");
			System.out.println("走るわん");
			System.out.println("お休みわん");
		} else {
			System.out.println("にゃんにゃん");
			System.out.println("食べるにゃん");
			System.out.println("攻撃するにゃん");
			System.out.println("走るにゃん");
			System.out.println("お休みにゃん");
		}
	}
}
