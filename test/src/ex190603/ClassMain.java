package ex190603;

public class ClassMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ClassPC3 myPC = new ClassPC3();
		myPC.setNum1(7);
		myPC.setNum2(9);
//		myPC.Sa();
//		int result=myPC.getResult();
//		System.out.println(result);
		myPC.judgeEven();
		//myPC.isEven = "微妙です";
		System.out.println("2つの数字は"+myPC.getIsEven());
	}

}