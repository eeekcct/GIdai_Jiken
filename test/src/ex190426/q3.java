package ex190426;

import java.io.*;
public class q3 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("金額（円）を入力してください");
		String str1 = br.readLine();
		int num1= Integer.parseInt(str1);
		System.out.println(num1+"円＝"+(num1*0.00893)+"ドル");
		System.out.println(num1+"円＝"+(num1*0.06003)+"元");
		System.out.println(num1+"円＝"+(num1*206.580)+"ドン");
	}
}
