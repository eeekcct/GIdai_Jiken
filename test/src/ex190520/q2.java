package ex190520;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.io.*;

public class q2 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("検索する得点を入力してください。");
		int score = Integer.parseInt(br.readLine());
		
		int[] scores = {
			76, 80, 68, 81, 72, 80, 70, 69, 86, 85,
			82, 78, 74, 93, 80, 92, 79, 76, 78, 67,
			86, 74, 88, 84, 68, 85, 94, 98, 81, 80,
			65, 80, 85, 80, 78, 90, 90, 79, 81, 95
		};
		
		IntPredicate tagetScore=(n) -> (n==score); 
		long val =Arrays.stream(scores).filter(tagetScore).count();
		System.out.println(score+"点の人は"+val+"人いました。");
	}

}

