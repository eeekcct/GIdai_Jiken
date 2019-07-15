package s13_sample01;

public class Dorami extends Shizuka {

	public String getAverageScoreOfNobita() {
		String str="";
		str += super.getAverageScoreOfNobita();
		str += "それに、今回は5点でも、心を入れ替えてちゃんと頑張ります。";
		return str;
	}

}
