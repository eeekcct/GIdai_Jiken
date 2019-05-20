package ex190520;

public class Sample01 {

	public static void main(String[] args) {
		int[] test;
		test = new int[5];
		test[0] = 80;
		test[1] = 65;
		test[2] = 70;
		test[3] = 92;
		test[4] = 100;

		for(int i = 0 ;i<test.length;i++){
			System.out.println(test[i]+"点");
		}
	}
}
