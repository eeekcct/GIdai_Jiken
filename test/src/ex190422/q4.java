package ex190422;

import java.io.*;
public class q4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("チーム名を教えてください。");
		String str1=br.readLine();
		System.out.println("今季、"+str1+"は何勝しましたか？");
		String str2=br.readLine();
		System.out.println("今季、"+str1+"は、"+str2+"勝し、何敗しましたか？");
		String str3 = br.readLine();
		System.out.println();
		System.out.println(str2+"勝"+str3+"負で"+str1+"はシーズンを終えました。");
	}

}
