package Baekjoon;

import java.io.*;
import java.util.*;

// 백준 2178. 미로 탐색
public class Baekjoon_2178 {

	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	static int N, M, cnt = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		
		for (int r = 1; r <= N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c+1] = str.charAt(c) - '0';
			}
		}
		
		visited[1][1] = true;
		bfs(1, 1);
		
		System.out.println(map[N][M]);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();

			for (int i = 0; i < 4; i++) {
				int rr = poll[0] + dr[i];
				int cc = poll[1] + dc[i];
				if (rr <= 0 || rr > N || cc <= 0 || cc > M) continue;
				if (map[rr][cc] >= 1 && !visited[rr][cc]) {
					queue.add(new int[] {rr, cc});
					map[rr][cc] = map[poll[0]][poll[1]] + 1;
					visited[rr][cc] = true;
				}
			}
		}
	}
}
