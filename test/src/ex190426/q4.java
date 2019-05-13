package ex190426;
import java.io.*;
public class q4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("好きな曲名を入力してね。");
		String str1 = br.readLine();
		System.out.print(str1+"の再生時間（分）を入力してね。");
		String str2 = br.readLine();
		System.out.print(str1+"の再生時間（秒）を入力してね。");
		String str3=br.readLine();
		System.out.print(str1+"を何回聞きたいですか？");
		String str4=br.readLine();
		int num1= Integer.parseInt(str2);
		int num2= Integer.parseInt(str3);
		int num3= Integer.parseInt(str4);
		int num4 = (num1*60+num2)*num3;
		System.out.println("「"+str1+"」で"+num4/3600+"時間"+num4%3600/60+"分"+num4%3600%60+"秒楽しめます。");
	}

}
