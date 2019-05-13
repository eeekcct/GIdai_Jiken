package ex190426;

import java.io.*;

public class q2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("あなたという人は。。。今日だけで");
		System.out.println();
		System.out.print("ショートケーキ(300Kcal)を何個食べちゃったんですか！");
		String str1 = br.readLine();
		System.out.print("おしるこ(200Kcal)を何杯食べちゃったんですか！");
		String str2 = br.readLine();
		System.out.print("アイスクリーム(250Kcal)を何本食べちゃったんですか！");
		String str3 = br.readLine();
		System.out.println();
		int num1 = Integer.parseInt(str1)*300;
		int num2 = Integer.parseInt(str2)*200;
		int num3 = Integer.parseInt(str3)*250;
		int num4 = (int)((num1+num2+num3)*7/7.2);
		System.out.println("こんな生活を続けていると\n1週間後にはあなたの体重は、"+num4+"g増加してますよ。");	
	}
}
