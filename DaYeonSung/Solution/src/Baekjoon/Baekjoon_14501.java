package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 14501. 퇴사
public class Baekjoon_14501 {

	static int N;
	static int[] T, P, dp;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N + 1];
		P = new int[N + 1];
		dp = new int[N + 2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N; i > 0; i--) {
			if (i + T[i] > N + 1) dp[i] = dp[i + 1];
			else {
				dp[i] = Math.max(dp[i+1],  P[i] + dp[i + T[i]]);
			}
		}
		
		System.out.println(dp[1]);
		
	}

}
