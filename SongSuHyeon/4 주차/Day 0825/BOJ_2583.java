package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2583 {

	static int M, N, K, num = 1;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					num++;
					dfs(i, j);
				}
			}
		}

		System.out.println(num - 1);

		int[] cntColor = new int[num+1];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != 1)
					cntColor[map[r][c]]++;
			}
		}

		Arrays.sort(cntColor);
		for (int i = 2; i < cntColor.length; i++) {
			System.out.print(cntColor[i] + " ");
		}

	}

	private static void dfs(int r, int c) {

		map[r][c] = num;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
				if (map[nr][nc] == 0) {
					map[nr][nc] = num;
					dfs(nr, nc);
				}
			}

		}

	}

}
