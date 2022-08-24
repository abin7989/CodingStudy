package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1976. 시각 덧셈
public class SWEA_1976 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int hr1 = Integer.parseInt(st.nextToken());
			int min1 = Integer.parseInt(st.nextToken());
			int hr2 = Integer.parseInt(st.nextToken());
			int min2 = Integer.parseInt(st.nextToken());
			
			int finalhr = hr1 + hr2;
			int finalmin = min1 + min2;
			if (finalmin >= 60) {
				finalhr += 1;
				finalmin -= 60;
			}
			if (finalhr > 12) finalhr -= 12;
			
			sb.append("#").append(tc).append(" ").append(finalhr).append(" ").append(finalmin).append("\n");
		}
		System.out.println(sb);
	}

}
