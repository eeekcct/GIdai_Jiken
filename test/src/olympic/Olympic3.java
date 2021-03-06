package olympic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Olympic3 {

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
			
			if(!eventIsOpened(year,month,day)) System.out.println("東京オリンピックまであと"+daysToOpen(year,month,day)+"日です。");
		else if(eventIsBeingHeld(year,month,day)) System.out.println("東京オリンピックは開催中です。");
		else System.out.println("東京オリンピックは終わりました。");
	}

	// ==================
	// Step 01
	// ==================
	public static boolean isLeapYear(int year) {
		return (year%4 == 0 && year % 100 != 0 )||(year % 4 == 0 && year % 400 == 0);
	}

	// ==================
	// Step 02
	// ==================
	public static int daysOfYear(int year) {
		if(isLeapYear(year)==true) return 366;
		else return 365;
	}

	// ==================
	// Step 03
	// ==================
	public static int daysOfMonth(int year, int month) {
		if(isLeapYear(year)==true && month == 2) return 29;
		switch (month) {
		case 2:
			return 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}

	// ==================
	// Step 04
	// ==================
	public static int daysFromNewYearsDay(int year, int month, int day) {
		int day2=0;
		for(int i=1;i<month;i++) day2+=daysOfMonth(year,i);
		return day2 + day- 1;
	}

	// ==================
	// Step 05
	// ==================
	public static int daysToNewYearsEve(int year, int month, int day) {
		return daysOfYear(year) - daysFromNewYearsDay(year,month,day) -1;
	}

	// ==================
	// Step 06
	// ==================
	public static int daysFromNewYearsDayOf2019(int year, int month, int day) {
		int day2 = 0;
		for(int i=2019;i<year;i++) day2 += daysOfYear(i);
		return day2 + daysFromNewYearsDay(year,month,day);
	}

	// ==================
	// Step 07
	// ==================
	public static int daysBetween(int firstYear, int firstMonth, int firstDay, int lastYear, int lastMonth, int lastDay) {
		return daysFromNewYearsDayOf2019(lastYear,lastMonth,lastDay) - daysFromNewYearsDayOf2019(firstYear,firstMonth,firstDay);
	}

	// ==================
	// Step 08
	// ==================
	public static int daysToOpen(int year, int month, int day) {
		return daysBetween(year,month,day,2020,7,24);
	}

	// ==================
	// Step 09
	// ==================
	public static int daysToClose(int year, int month, int day) {
		return daysBetween(year,month,day,2020,8,9);
	}

	// ==================
	// Step 10
	// ==================
	public static boolean eventIsOpened(int year, int month, int day) {
		return daysToOpen(year,month,day)<=0;
	}

	// ==================
	// Step 11
	// ==================
	public static boolean eventIsClosed(int year, int month, int day) {
		return daysToClose(year,month,day)<0;
	}

	// ==================
	// Step 12
	// ==================
	public static boolean eventIsBeingHeld(int year, int month, int day) {
		return eventIsOpened(year,month,day) && !eventIsClosed(year,month,day);
	}
}
