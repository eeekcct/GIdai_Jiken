package ex190516;

import java.io.*;

public class q2 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("整数を入力してください。");
		String str = br.readLine();
		int n = Integer.parseInt(str);
		int sum_gusu=0;
		int sum_kisu=0;
		for(int i=0;i<=n;i++){
			if(i%2==0) sum_gusu += i;
			else sum_kisu += i;
		}
		System.out.println("1から"+n+"までの偶数の和＝"+sum_gusu);
		System.out.println("1から"+n+"までの奇数の和＝"+sum_kisu);

	}

}
