package ex190516;

import java.io.*;

public class q3 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("正の整数を入力してください。");
		String str = br.readLine();
		int n = Integer.parseInt(str);
		int sum=0;
		for(int i=0;i<=n;i++){
			sum += i*i;
		}
		System.out.println("1から"+n+"までの二乗の和＝"+sum);

	}

}