package ex190516;

import java.io.*;

public class q4 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("2019年N月からM月までの日数を求めます。\n正の整数Nを入力してください。");
		String strn = br.readLine();
		System.out.println("正の整数Mを入力してください。");
		String strm = br.readLine();
		int n = Integer.parseInt(strn);
		int m = Integer.parseInt(strm);
		int sum = 0;
		
		for(int i=n;i<=m;i++) sum += monthdays(i);
		System.out.println("2019年"+n+"月から"+m+"月までは"+sum+"日です。");

		
	}

public static int monthdays(int month){
	switch(month){
		case 2: 
			return 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
	}
}
}
