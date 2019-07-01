package s11_51;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample11_51 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("昼=0、夜=1");
		String str = br.readLine();
		int ans = Integer.parseInt(str);

		Employee sengoku;
		if (ans == 0) {
			sengoku = new DayEmployee();
		} else {
			sengoku = new NightEmployee();
		}

		Shop laBelleEquipe = new Shop();
		laBelleEquipe.setEmployee(sengoku);
		laBelleEquipe.open();
	}
}
