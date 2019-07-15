package s13_sample022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample13_022 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("犬or猫（犬=0、猫=1）？");
		String str = br.readLine();
		
		Animal mypet;
		int num = Integer.parseInt(str);
		if (num == 0) {
			mypet = new Dog();
		} else {
			mypet = new Cat();
		}

		String strCry = mypet.cry();
		String strEat = mypet.eat();
		String strAttack = mypet.attack();
		String strRun = mypet.run();
		String strSleep = mypet.sleep();

		System.out.println(strCry);
		System.out.println(strEat);
		System.out.println(strAttack);
		System.out.println(strRun);
		System.out.println(strSleep);
	}
}
