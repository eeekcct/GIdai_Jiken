package ex190520;

import java.util.Arrays;

import java.util.function.IntToDoubleFunction;


public class q3 {

	public static void main(String[] args) {

		int[] scores = {
			76, 80, 68, 81, 72, 80, 70, 69, 86, 85,
			82, 78, 74, 93, 80, 92, 79, 76, 78, 67,
			86, 74, 88, 84, 68, 85, 94, 98, 81, 80,
			65, 80, 85, 80, 78, 90, 90, 79, 81, 95
		};

		IntToDoubleFunction gradePoint= n -> {
			if(n>=90) return 4.0;
			else if(n>=80) return 3.0;
			else if(n>=70) return 2.0;
			else if(n>=60) return 1.0;
			else return 0.0;
		};
		Arrays.stream(scores).mapToDouble(gradePoint).forEach(System.out::println);
	}

}

