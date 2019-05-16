package ex190516;

import java.io.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class q2d {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("整数を入力してください。");
		String str = br.readLine();
		int n = Integer.parseInt(str);

		IntPredicate isEven = (int x) -> x%2==0;
		IntPredicate isOdd = (int y) -> y%2!=0;
		int answer1 = IntStream.rangeClosed(1,n).filter(isEven).sum();
		int answer2 = IntStream.rangeClosed(1,n).filter(isOdd).sum();
		System.out.println("1から"+n+"までの偶数の和＝"+answer1);
		System.out.println("1から"+n+"までの奇数の和＝"+answer2);

	}

}
