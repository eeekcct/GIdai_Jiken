package ex190422;

import java.io.*;
public class q3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("「勇気」と最後につければ");
		System.out.println("大抵の言葉はポジティブに変換できますよ。");
		System.out.print("あなたがしたいことを入力して見てください：");
		String str1 = br.readLine();
		System.out.println();
		System.out.println("「"+str1+"勇気」");
		System.out.println("ほんとだ！");
		System.out.println("実際には"+str1+"だけなのに、");
		System.out.println("何か重要な目的のために自分を犠牲にして、");
		System.out.println("あえて、"+str1+"ように聞こえる！");
	}
}
