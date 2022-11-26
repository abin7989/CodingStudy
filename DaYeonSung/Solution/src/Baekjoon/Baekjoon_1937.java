package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1937. 욕심쟁이 판다
public class Baekjoon_1937 {

	static int n, maxCnt = Integer.MIN_VALUE;
	static int[][] bamboos, maxCnts;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		bamboos = new int[n][n];
		maxCnts = new int[n][n];
		
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < n; c++) {
				bamboos[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (maxCnts[r][c] != 0) continue;
				maxCnts[r][c] = 1;
				maxCnt = Math.max(maxCnt, eatBamboo(r, c, 1));
			}
		}
		
		System.out.println(maxCnt);

	}
	
	private static int eatBamboo(int r, int c, int cnt) {
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= n || nc >= n || bamboos[r][c] >= bamboos[nr][nc]) continue;
						
			if (maxCnts[nr][nc] == 0) {
				int nextCnt = eatBamboo(nr, nc, cnt + 1);
				maxCnts[r][c] = Math.max(maxCnts[r][c], nextCnt + 1);
			} else {
				maxCnts[r][c] = Math.max(maxCnts[r][c], maxCnts[nr][nc] + 1);
			}
		}
		
		if (maxCnts[r][c] == 0) return 1;
		return maxCnts[r][c];
	}

}

