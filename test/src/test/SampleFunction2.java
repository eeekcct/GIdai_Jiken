package test;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class SampleFunction2 {

	public static void main(String[] args) {
		int n=3;
		int m=10;

		IntPredicate multipleOf3 = (int x) -> {
			if(x % 3 ==0) return true;
			else return false;
		};
		long answer = IntStream.rangeClosed(n,m).filter(multipleOf3).filter(multipleOf3).count();

		System.out.println(answer);
	}

}
