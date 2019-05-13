package object20190513;

public class Object02 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int answer = functionF(6);
		System.out.println(answer);
		answer = functionF(20);
		System.out.println(answer);
		answer = functionQ(8);
		System.out.println(answer);
	}
	public static int functionF(int num){
		int ans;
		ans=3*num+7;
		return ans;
	}
	public static int functionQ(int num){
		int ans;
		ans = 2*num*num+7*num+5;
		return ans;
	}

}
