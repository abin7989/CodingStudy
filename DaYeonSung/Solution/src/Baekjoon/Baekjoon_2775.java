package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 2775. 부녀회장이 될테야
public class Baekjoon_2775 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] apart = new int[k + 1][n + 1];
			
			for (int i = 1; i < n + 1; i++) {
				apart[0][i] = i;
			}
			
			for (int r = 1; r <= k; r++) {
				for (int c = 1; c <= n; c++) {
					int sum = 0;
					for (int i = 1; i <= c; i++) {
						sum += apart[r-1][i];
					}
					apart[r][c] = sum;
				}
			}
			
			sb.append(apart[k][n]).append("\n");
			
		}
		System.out.println(sb);
		
	}

}