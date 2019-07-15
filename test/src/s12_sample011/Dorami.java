package s12_sample011;

public class Dorami extends Shizuka{
	public String getAverageScoreOfNobita() {
		String str="";
		str+=super.getAverageScoreOfNobita();
		str+="それに、今回は5点でも、心を入れ替えてちゃんとがんばります。";
		return str;
	}
}
