package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1926. 그림
public class Baekjoon_1926 {

	static int n, m;
	static int[][] paper;
	static boolean[][] visited;
	static int cnt, max;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		paper = new int[n][m];
		visited = new boolean[n][m];
		
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < m; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
				if (paper[r][c] == 0) {
					visited[r][c] = true;
				}
			}
		}
		
		cnt = 0;
		max = 0;
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (!visited[r][c] && paper[r][c] == 1) {
					bfs(r, c);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);

	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		int area = 0;
		while(!queue.isEmpty()) {
			area++;
			int[] poll = queue.poll();
			int pollR = poll[0];
			int pollC = poll[1];
			
			
			for (int i = 0; i < 4; i++) {
				int nr = pollR + dr[i];
				int nc = pollC + dc[i];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) continue;
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
		cnt++;
		if (area > max) max = area;
	}

}
