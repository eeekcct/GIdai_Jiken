package ex190516;

import java.io.*;

public class q1 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean p=false;
		while(!p){
			System.out.print("逃げてもいいですか？(Y or N)：");
			String str = br.readLine();
			if(str.equals("N")) p = true;
			else System.out.println("逃げちゃだめだ！");
		}
			System.out.println("あなたは死なないわ。。。私が守るもの。");
	}

}
