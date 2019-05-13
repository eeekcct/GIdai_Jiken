package object20190513;

public class Object03 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		say("こんにちは",5);
		say("さようなら",10);
		say("おはよう",3);

	}
	public static void say(String word,int num){
		for(int i=0;i<num;i++){
			System.out.println(translate(word));
		}
	}
	public static String translate(String word){
		if(word.equals("こんにちは")){
			return "Hello.";
		}
		else if(word.equals("さようなら")){
			return "Good bye.";
		}
		return "What?";
	}

}
