package ex190520;

import java.util.Arrays;


public class q4 {

	public static void main(String[] args) {

		int[] scores = {
			76, 80, 68, 81, 72, 80, 70, 69, 86, 85,
			82, 78, 74, 93, 80, 92, 79, 76, 78, 67,
			86, 74, 88, 84, 68, 85, 94, 98, 81, 80,
			65, 80, 85, 80, 78, 90, 90, 79, 81, 95
		};
		int sum = Arrays.stream(scores).sum();
		long val = Arrays.stream(scores).count();
		double score = (double)sum/val;
		System.out.println("平均点は["+score+"]点です。");
	}

}

