package ex190426;

import java.io.*;

public class q1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("IBM-5100をいくらで買いますか？");
		String str1 = br.readLine();
		System.out.println("消費税は何％ですか？");
		String str2 = br.readLine();
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int num3 = num1+num1*num2/100;
		System.out.println();
		System.out.println("お支払い金額は"+num3+"なのです。");
	}
}
