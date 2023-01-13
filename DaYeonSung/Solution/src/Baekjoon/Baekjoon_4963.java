package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 4963. 섬의 개수
public class Baekjoon_4963 {

	static int w, h, cnt = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상 하 좌 우 좌상 우상 좌하 우하
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1}; // 상 하 좌 우 좌상 우상 좌하 우하
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 || h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 0) visited[r][c] = true;
				}
			}
			
			cnt = 0;
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (!visited[r][c]) {
						cnt++;
						findIsland(r, c);
					}
				}
			}
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb);

	}
	
	private static void findIsland(int r, int c) {
		visited[r][c] = true;
		
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
			
			if (!visited[nr][nc]) findIsland(nr, nc);
		}
	}

}
