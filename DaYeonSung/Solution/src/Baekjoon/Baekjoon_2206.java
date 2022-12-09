package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2206. 벽 부수고 이동하기
public class Baekjoon_2206 {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		int ans = go();
		
		// 0은 이동할 수 있는 곳
		// 1은 이동할 수 없는 벽이 있는 곳
		
		System.out.println(ans);

	}
	
	private static int go() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0, 1, 0});
		visited[0][0][0] = true; // 0은 벽 부시지 않고의 방문 여부
		visited[0][0][1] = true; // 1은 벽 부수고의 방문 여부
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int r = poll[0];
			int c = poll[1];
			int cnt = poll[2];
			int wall = poll[3];
			
			if (r == N - 1  && c == M - 1) {
				return cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				if (map[nr][nc] == 0) {
					if (visited[nr][nc][wall] == false) {
						queue.add(new int[] {nr, nc, cnt + 1, wall});
						visited[nr][nc][wall] = true;
					}
				} else if (map[nr][nc] == 1) {
					if (wall == 0 && !visited[nr][nc][1]) {
						queue.add(new int[] {nr, nc, cnt + 1, 1});
						visited[nr][nc][1] = true;
					}
				}
			}
		}
		
		return -1;
	}

}
