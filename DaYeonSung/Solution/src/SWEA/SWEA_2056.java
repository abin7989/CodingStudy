package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 2056. 연월일 달력
public class SWEA_2056 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			String str = br.readLine(); // 날짜 입력 받기
			String year = str.substring(0, 4);
			String month = str.substring(4, 6);
			String day = str.substring(6, 8);
			
			if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) {
				sb.append("#").append(tc).append(" ").append("-1\n");
				continue;
			}
			if (days[Integer.parseInt(month) - 1] < Integer.parseInt(day)) {
				sb.append("#").append(tc).append(" ").append("-1\n");
				continue;
			}
			sb.append("#").append(tc).append(" ").append(year).append("/").append(month).append("/").append(day).append("\n");
			
		}
		System.out.println(sb);

	}

}
