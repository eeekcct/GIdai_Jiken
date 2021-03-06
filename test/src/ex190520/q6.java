package ex190520;

import java.util.Arrays;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class q6 {

	public static void main(String[] args) {

		int[] scores = {
			76, 80, 68, 81, 72, 80, 70, 69, 86, 85,
			82, 78, 74, 93, 80, 92, 79, 76, 78, 67,
			86, 74, 88, 84, 68, 85, 94, 98, 81, 80,
			65, 80, 85, 80, 78, 90, 90, 79, 81, 95
		};

		IntPredicate rankS = n -> n>=90;
		IntPredicate rankA = n -> n>=80 && n<90;
		IntPredicate rankB = n -> n>=70 && n<80;
		IntPredicate rankC = n -> n>=60 && n<70;
		IntPredicate rankD = n -> n<60;
		
		IntFunction<String> toStar = n -> {return "*";};
		
		long rankS_val = Arrays.stream(scores).filter(rankS).count();
		long rankA_val = Arrays.stream(scores).filter(rankA).count();
		long rankB_val = Arrays.stream(scores).filter(rankB).count();
		long rankC_val = Arrays.stream(scores).filter(rankC).count();
		long rankD_val = Arrays.stream(scores).filter(rankD).count();
		
		//LongFunction<String> Star_S = (long price ) -> {return price+"*";};
		String Star_S = IntStream.rangeClosed(1,(int)rankS_val).mapToObj(toStar).collect(Collectors.joining());
		String Star_A = IntStream.rangeClosed(1,(int)rankA_val).mapToObj(toStar).collect(Collectors.joining());
		String Star_B = IntStream.rangeClosed(1,(int)rankB_val).mapToObj(toStar).collect(Collectors.joining());
		String Star_C = IntStream.rangeClosed(1,(int)rankC_val).mapToObj(toStar).collect(Collectors.joining());
		String Star_D = IntStream.rangeClosed(1,(int)rankD_val).mapToObj(toStar).collect(Collectors.joining());
		
		
		System.out.println("RankS："+Star_S);
		System.out.println("RankA："+Star_A);
		System.out.println("RankB："+Star_B);
		System.out.println("RankC："+Star_C);
		System.out.println("RankD："+Star_D);
		
	}

}
