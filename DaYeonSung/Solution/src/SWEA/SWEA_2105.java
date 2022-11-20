package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 2105. 디저트 카페
public class SWEA_2105 {
	
	static int N;
	static int[][] map;
	static int[] dr = { 1, 1, -1, -1 }; // 우하 좌하 좌상 우상
	static int[] dc = { 1, -1, -1, 1 }; // 우하 좌하 좌상 우상
	static boolean[][] visited;
	static boolean[] desserts;
	static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			
			for (int r = 0; r < N - 2; r++) {
				for (int c = 1; c < N - 1; c++) {
					visited = new boolean[N][N];
					desserts = new boolean[101];
					visited[r][c] = true;
					desserts[map[r][c]] = true;
					dessertTour(1, r, c, r, c, 0);
				}
			}
			
			if (max == 0) max = -1;
			sb.append(max).append("\n");
		}
		System.out.println(sb);

	}
	
	private static void dessertTour(int cnt, int r, int c, int startR, int startC, int preDir) {
		for (int i = preDir; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			
			if (nr == startR && nc == startC && cnt > 2) {
				max = Math.max(max, cnt);
				return;
			}
			
			if (!visited[nr][nc] && !desserts[map[nr][nc]]) {
				visited[nr][nc] = true;
				desserts[map[nr][nc]] = true;
				dessertTour(cnt + 1, nr, nc, startR, startC, i);
				visited[nr][nc] = false;
				desserts[map[nr][nc]] = false;
			}
		}
	}

}
