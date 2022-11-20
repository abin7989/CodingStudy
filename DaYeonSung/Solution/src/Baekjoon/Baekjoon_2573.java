package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2573. 빙산
public class Baekjoon_2573 {

	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 0, 1}; // 상 좌 우 하
	static int[] dc = {0, -1, 1, 0}; // 상 좌 우 하
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		boolean flag = true;
		while(true) {
			if (examineIce() == -1) {
				melt();
				time++;				
			} else if (examineIce() == 1) {
				break;
			} else if (examineIce() == 0) {
				time = 0;
				break;
			}
		}
		
		System.out.println(time);
		

	}
	
	static boolean[][] visited;
	private static int examineIce() {
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) visited[r][c] = true;
			}
		}
		
		int cntIce = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c]) {
					cntIce++;
					dfs(r, c, visited);
				}
			}
		}
		
		if (cntIce >= 2) return 1;
		else if (cntIce == 0) return 0;
		else return -1;
		
	}
	
	private static void dfs(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			
			if (!visited[nr][nc]) {
				dfs(nr, nc, visited);
			}
		}
	}
	
	private static void melt() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] > 0) {
                	queue.offer(new int[] {r, c});
                	visited[r][c] = true;
                }
            }
        }
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int pollR = poll[0];
			int pollC = poll[1];
			
			int sea = 0;
			
			for (int i = 0; i < 4; i++) {
				int nr = pollR + dr[i];
				int nc = pollC + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
				
				if (!visited[nr][nc] && map[nr][nc] == 0) {
					sea++;
				}
			}
			
			if (map[pollR][pollC] - sea < 0) {
				map[pollR][pollC] = 0; // 각 칸에 저장된 높이는 0보다 더 줄어들지 않기 때문에 0보다 작아지는 경우 0을 저장
			} else {
				map[pollR][pollC] -= sea;
			}
		}
	}

}
