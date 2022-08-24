package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1493. 수의 새로운 연산
public class SWEA_1493 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int x1 = solve_x(p);
			int x2 = solve_x(q);
			int y1 = solve_y(p);
			int y2 = solve_y(q);

			int ans = finalSolve(x1 + x2, y1 + y2);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static int solve_x (int n) {
		int num = 1; // 격자점에 넣어줄 값 초기값
		int x = 1;
		int cnt = 1;
		while (num != n) {
			cnt += 1;
			for (int i = 1; i <= cnt; i++) {
				x = i;
				num += 1;
				if (num == n) break;
			}
		}
		return x;
	}
	
	private static int solve_y (int n) {
		int num = 1; // 격자점에 넣어줄 값 초기값
		int y = 1;
		int cnt = 1;
		while (num != n) {
			cnt += 1;
			for (int i = cnt; i >= 1; i--) {
				y = i;
				num += 1;
				if (num == n) break;
			}
		}
		return y;
	}
	
	private static int finalSolve (int x, int y) {
		int num = 1;
		int cnt = 1;
		while (true) {
			for (int p = 1, q = cnt; p <= cnt && q >= 1; p++, q--) {
				if (p == x && q == y) return num;
				num += 1;
			}
			cnt += 1;
		}
	}
	
}