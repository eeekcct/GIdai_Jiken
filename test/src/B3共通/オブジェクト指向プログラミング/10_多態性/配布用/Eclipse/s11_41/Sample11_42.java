package s11_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample11_42 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("犬or猫（犬=0、猫=1）？");
		String str = br.readLine();
		int type = Integer.parseInt(str);

		Animal mypet=new Animal(type);

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
