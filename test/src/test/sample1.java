package test;

import java.io.*;

public class sample1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(str+"が入力されたよ");
	}
}
