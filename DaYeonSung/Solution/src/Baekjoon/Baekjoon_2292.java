package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 2292. 벌집
public class Baekjoon_2292 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = 2;
		int end = 7;
		int cnt = 2;
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 1;
		
		if (N != 1) {
			while(true) {
				if (start <= N && N <= end) {
					ans = cnt;
					break;
				} else {
					start += (6 * (cnt - 1));
					end += (6 * cnt);
					cnt++;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
}
