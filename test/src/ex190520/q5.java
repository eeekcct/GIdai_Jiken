package ex190520;

import java.util.Arrays;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;


public class q5 {

	public static void main(String[] args) {

		int[] scores = {
			76, 80, 68, 81, 72, 80, 70, 69, 86, 85,
			82, 78, 74, 93, 80, 92, 79, 76, 78, 67,
			86, 74, 88, 84, 68, 85, 94, 98, 81, 80,
			65, 80, 85, 80, 78, 90, 90, 79, 81, 95
		};
		IntBinaryOperator max = (n,m) -> {
			if(n>m) return n;
			return m;
		};
		int top1=Arrays.stream(scores).reduce(0, max);
		IntPredicate lessThanTop1 = n -> n<top1;
		int top2=Arrays.stream(scores).filter(lessThanTop1).reduce(0, max);
		IntPredicate lessThanTop2 = n -> n<top2;
		int top3=Arrays.stream(scores).filter(lessThanTop2).reduce(0,max);
		System.out.println("最高点は["+top1+"]です。");
		System.out.println("2位の得点は["+top2+"]です。");
		System.out.println("3位の得点は["+top3+"]です。");
	}

}
