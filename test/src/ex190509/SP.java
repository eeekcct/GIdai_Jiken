package ex190509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SP {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("今年は西暦何年ですか？");
			String str = br.readLine();
			System.out.print("今月は何月ですか？");
			String str2 = br.readLine();
			System.out.print("今日は何日ですか？");
			String str3 = br.readLine();
			
			int year = Integer.parseInt(str);
			int month = Integer.parseInt(str2);
			int day = Integer.parseInt(str3);

			if(year < 2020 || (year == 2020 && (month < 7 || month == 7 && day < 24))) {
				int day2=0;
				switch(month){
					case 1:
						day2 = 205;
						break;
					case 2:
						day2 = 174;
						break;
					case 3:
						day2 = 145;
						break;
					case 4:
						day2 = 114;
						break;
					case 5:
						day2 = 84;
						break;
					case 6:
						day2 = 53;
						break;
					case 7:
						day2 = 23;
						break;
					case 8:
						day2 = 358;
						break;
					case 9:
						day2 = 327;
						break;
					case 10:
						day2 = 297;
						break;
					case 11:
						day2 = 266;
						break;
					case 12:
						day2 = 236;
						break;
					default:
						System.out.println("入力ミス");
						break;
				}
				if(year == 2019 && month < 8) {
					if(month < 3) day2 += 365;
					else day2 += 366;
				}
				
				System.out.println("東京オリンピックまで、あと"+(day2 - day + 1)+"日です。");
			}
			else if(year > 2020 || (year == 2020 && month>8) || (year == 2020 && month == 8 && day > 9)) System.out.println("東京オリンピックは終わりました。");
			else{
				System.out.println("東京オリンピックは開催中です。");
			}
		}
}
