package ex190516;

import java.io.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class q3d {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("整数を入力してください。");
		String str = br.readLine();
		int n = Integer.parseInt(str);

		IntUnaryOperator pow2 = (int x) -> x*x;
		int answer1 = IntStream.rangeClosed(1,n).map(pow2).sum();
		System.out.println("1から"+n+"までの二乗の和＝"+answer1);

	}

}