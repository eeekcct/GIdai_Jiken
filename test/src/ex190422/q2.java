package ex190422;
import java.io.*;
public class q2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("何を買うんですか？");
		String str1 = br.readLine();
		System.out.println("おいくらですか？");
		String much = br.readLine();
		int nedan=Integer.parseInt(much);
		System.out.println(str1+"って\\"+nedan+"もするんですか？");
	}

}
