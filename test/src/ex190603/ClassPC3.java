package ex190603;

public class ClassPC3 extends ClassPC {
	public boolean isEven;

	public void judgeEven() {
		if(num1 == num2) isEven = true;//"同じです。";
		else isEven = false;//"違います。";
	}
	public String getIsEven() {
		if(num1 == num2) return "同じです";
		else return "違います";
	}
}
