	package object20190513;

public class Object04 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int num[] = {50,60,20,40,80,100,10,0};
		for(int i=0;i<num.length-1;i++){
			for(int j=i;j<num.length;j++){
				if(num[i]>num[j]){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		for(int i=0;i<num.length;i++){
			System.out.println(num[i]);
		}

	}

}
