package s13_sample01;

public class ScoreBook {
	private double nobitaKokugo=3;
	private double nobitaSansu=0;
	private double nobitaRika=1;
	private double nobitaSyakai=1;

	public double getSum(){
		return nobitaKokugo+nobitaSansu+nobitaRika+nobitaSyakai;
	}

	public double getAverage() {
		double sum=getSum();
		return sum/4;
	}

	public double getMax(){
		double max=0;
		if( max< nobitaKokugo){
			max=nobitaKokugo;
		}
		if( max< nobitaSansu){
			max=nobitaSansu;
		}
		if( max< nobitaRika){
			max=nobitaRika;
		}
		if( max< nobitaSyakai){
			max=nobitaSyakai;
		}
		return max;

	}

}
