package s11_43;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import s11_41.Animal;

public class Sample11_44 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("犬or猫（犬=0、猫=1）？");
		String str = br.readLine();
		int num = Integer.parseInt(str);

		Animal mypet;
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
