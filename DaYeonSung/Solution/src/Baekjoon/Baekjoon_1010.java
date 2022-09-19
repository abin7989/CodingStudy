package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1010. 다리 놓기
public class Baekjoon_1010 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {	
			
			st = new StringTokenizer(br.readLine());
			long R = Long.parseLong(st.nextToken());
			long N = Long.parseLong(st.nextToken());
			
			if (R > N / 2) {
				R = N - R;
			}
			
			int ans = 1;
			
			for (int i = 0; i < R; i++) {
				ans *= (N - i);
				ans /= (i + 1);
			}
						
			sb.append(ans).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
}
