package ex190520;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class q1 {

	public static void main(String[] args) {
		int[] scores = {
			76, 80, 68, 81, 72, 80, 70, 69, 86, 85,
			82, 78, 74, 93, 80, 92, 79, 76, 78, 67,
			86, 74, 88, 84, 68, 85, 94, 98, 81, 80,
			65, 80, 85, 80, 78, 90, 90, 79, 81, 95
		};
		IntBinaryOperator min =(n,m) -> {
			if(n<m) return n;
			else return m;
		};
		int val =Arrays.stream(scores).reduce(100,min);
		System.out.println("最小値＝"+val);
	}

}
