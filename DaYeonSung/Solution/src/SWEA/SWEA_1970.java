package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 1970. 쉬운 거스름돈
public class SWEA_1970 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int price = Integer.parseInt(br.readLine());
			int mon1 = price / 50000;
			price -= mon1 * 50000;
			int mon2 = price / 10000;
			price -= mon2 * 10000;
			int mon3 = price / 5000;
			price -= mon3 * 5000;
			int mon4 = price / 1000;
			price -= mon4 * 1000;
			int mon5 = price / 500;
			price -= mon5 * 500;
			int mon6 = price / 100;
			price -= mon6 * 100;
			int mon7 = price / 50;
			price -= mon7 * 50;
			int mon8 = price / 10;
			price -= mon8 * 10;
			
			sb.append("#").append(tc).append("\n");
			sb.append(mon1).append(" ").append(mon2).append(" ").append(mon3).append(" ").append(mon4).append(" ").append(mon5).append(" ").append(mon6).append(" ").append(mon7).append(" ").append(mon8).append("\n");
		}
		System.out.println(sb);
	}

}
