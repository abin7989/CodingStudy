package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2468. 안전 영역
public class Baekjoon_2468 {

	static int N;
	static int[][] map;
	static boolean[][] checked;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		int maxHeight = 0; // 비가 가장 많이 왔을 때의 높이
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > maxHeight) maxHeight = map[r][c];
			}
		}
		
		int ans = 0;
		
		for (int h = 0; h <= maxHeight; h++) {
			checked = new boolean[N][N];
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!checked[r][c] && map[r][c] > h) { // 아직 체크하지 않았고, 안전한 영역이라면
						cnt++; // 카운트
						dfs(r, c, h);
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	
	private static void dfs(int r, int c, int height) {
		checked[r][c] = true;
		
		for (int i = 0; i < 4; i++) { // 4방향 탐색
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if (checked[nr][nc]) continue;
			if (map[nr][nc] > height) {
				dfs(nr, nc, height);
			}
		}
	}
	
}
