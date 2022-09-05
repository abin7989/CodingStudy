package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 2999. 비밀 이메일
public class Baekjoon_2999 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int len = str.length();
		
		int R = 1;
		int C = 1;
		
		for (int r = 1; r <= len / 2; r++) {
			if (len % r == 0 && (len / r) >= r) {
				if (r > R) R = r;
			}
		}
		
		C = len / R;
		
		char[][] map = new char[R][C];
		
		int cnt = 0;
		
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				map[r][c] = str.charAt(cnt++);
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
		}

		System.out.println(sb);
	}

}
