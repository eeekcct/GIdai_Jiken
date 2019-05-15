package olympic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Olympic2TooBadSample {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("今年は西暦何年ですか？");
String a = br.readLine();
int b = Integer.parseInt(a);
System.out.println("今は何月ですか？");
String cx = br.readLine();
int ddd = Integer.parseInt(cx);
if (b > 2020) {
System.out.println("東京オリンピックはもう終わってます！！");
} else if (b == 2020) {
		if (ddd == 7 || ddd == 8) {
	System.out.println("東京オリンピックは今月です！");
	} else if (ddd > 8) {
                System.out.println("東京オリンピックはもう終わってます！！");
		} else {
			System.out.println("東京オリンピックまで、あと" + (7 - ddd) + "カ月です");
	}} else {			int dddd = 2020 - b;
		if (ddd >= 8) {
dddd--;	}
	int d5 = (19 - dddd) % 12;
int t = dddd * 12 + d5;
System.out.println("東京オリンピックまで、あと" + t + "ケ月です");}}}
