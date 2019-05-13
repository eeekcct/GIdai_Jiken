package ex190426;

import java.io.*;

public class Sample01 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1; 
		int num2;
		
		System.out.println("num1は？");
		String str1 = br.readLine();

		System.out.println("num2は？");
		String str2 = br.readLine();

		num1 = Integer.parseInt(str1);
		num2 = Integer.parseInt(str2);

		int sum = num1 % num2;

		System.out.println("num1*num2=" + sum);

		//num1++;
		//num1+=1;

		double dnum1 = num1;

		System.out.println("num1=" + dnum1);

		int num3 = (int)dnum1;

		System.out.println("num3=" + num3);
	}
}
