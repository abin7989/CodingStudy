package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 20437. 문자열 게임 2
public class Baekjoon_20437 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] alpha = new int[26];
		
		for (int tc = 0; tc < T; tc++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			if (K == 1) {
				sb.append("1 1\n");
				continue;
			}
			
			// 알파벳 개수 저장
			for (int i = 0; i < W.length(); i++) {
				alpha[W.charAt(i) - 'a']++;
			}
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < W.length(); i++) {
				if (alpha[W.charAt(i) - 'a'] < K) continue; // K개보다 적은 알파벳인 경우 continue
				
				int cnt = 1;
				for (int j = i + 1; j < W.length(); j++) {
					if (W.charAt(i) == W.charAt(j)) cnt++;
					
					if (cnt == K) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break;
					}
				}
			}
			
			if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
				sb.append("-1\n");
			} else {
				sb.append(min + " " + max).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
