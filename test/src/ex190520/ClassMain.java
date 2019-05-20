package ex190520;

public class ClassMain {

	public static void main(String[] args) {
		ClassPC shodaiPC = new ClassPC();
		shodaiPC.setNum1(8);
		shodaiPC.setNum2(5);
		shodaiPC.Wa();
		int kotae = shodaiPC.getResult();
		System.out.println("足した結果は"+kotae);
		shodaiPC.Sa();
		kotae = shodaiPC.getResult();
		System.out.println("引いた結果は"+kotae);

		ClassPC nidaimePC = new ClassPC();
		nidaimePC.setNum1(15);
		nidaimePC.setNum2(7);
		nidaimePC.Sa();
		kotae = nidaimePC.getResult();
		System.out.println("引いた結果は"+kotae);

		shodaiPC.setNum2(100);
		shodaiPC.Sa();
		kotae = shodaiPC.getResult();
		System.out.println("引いた結果は"+kotae);
	}

}