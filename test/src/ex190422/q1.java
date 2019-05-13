package ex190422;
import java.io.*;
public class q1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1,str2,str3,str4;
		System.out.println("メンバー1の名前を入力してください。");
		str1=br.readLine();
		System.out.println("メンバー2の名前を入力してください。");
		str2=br.readLine();
		System.out.println("メンバー3の名前を入力してください。");
		str3=br.readLine();
		System.out.println("メンバー4の名前を入力してください。");
		str4=br.readLine();
		System.out.println("この世界には、"+str1+"、"+str2+"、"+str3+"、"+str4+"が登場します");
	}
}
