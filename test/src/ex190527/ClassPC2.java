package ex190527;

public class ClassPC2 extends ClassPC{
	public void sumInt() {
		result =0;
		if(num1>num2) {
			for(int i=num2;i<=num1;i++) {
				result += i;
			}
		}
		else{
			for(int i= num1;i<=num2;i++) {
				result += i;
			}
		}
	}
	public void Sa() {
		if(num1 > num2) {
			result = num1 -num2;
		}
		else {
			result = num2 - num1;
		}
	}
}
