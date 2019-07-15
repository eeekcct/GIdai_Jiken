package s13_sample01;

public class Teacher implements Friend{
	public String getAverageScoreOfNobita() {
		ScoreBook scorebook=new ScoreBook();
		double sum=scorebook.getSum();
		double average=scorebook.getAverage();
		return "４科目の合計は"+sum+"点。平均点は"+average +"点です。";
	}

}
