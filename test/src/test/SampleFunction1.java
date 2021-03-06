package test;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class SampleFunction1 {

	public static void main(String[] args) {
		IntPredicate isEven = (int n) -> {
			if(n % 2 == 0){
				return true;
			}
			else return false;
		};
		int answer = IntStream.rangeClosed(1,10).filter(isEven).sum();
		System.out.println(answer);
	}

}
