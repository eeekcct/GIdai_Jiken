package ex190422;

import java.io.*;
public class SPX {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1：ソウルジャム　　　　 50000円");
		System.out.println("2：グリープシード　　2500000円");
		System.out.println("3：きゅうべぇ　　　　　　　2円");
		System.out.print("何番の商品を購入しますか？");
		String str1=br.readLine();
		System.out.print("何個購入しますか？");
		String str2=br.readLine();
		int num=Integer.parseInt(str1);
		int val=Integer.parseInt(str2);
		int kingaku=(3-num)*(2-num)*25000*val;
		int kingaku2=(num-1)*(3-num)*2500000*val;
		int kingaku3=(num-1)*(num-2)*val;
		int goukei=kingaku+kingaku2+kingaku3;
		System.out.println("合計金額は"+goukei+"円です。");
		}
}
