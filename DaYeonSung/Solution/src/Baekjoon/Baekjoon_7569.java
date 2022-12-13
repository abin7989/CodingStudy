package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 7569. 토마토
public class Baekjoon_7569 {

	static int N, M, H;
	static int[][][] boxes;
	static Queue<int[]> tomatoQ;
	static int[] di = {0, 0, 0, 0, 1, -1}; // 상 하 좌 우 앞 뒤
	static int[] dr = {-1, 1, 0, 0, 0, 0}; // 상 하 좌 우 앞 뒤
	static int[] dc = {0, 0, -1, 1, 0, 0}; // 상 하 좌 우 앞 뒤
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		boxes = new int[H][N][M];
		tomatoQ = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < M; c++) {
					boxes[i][r][c] = Integer.parseInt(st.nextToken());
					if (boxes[i][r][c] == 1) {
						tomatoQ.offer(new int[] {i, r, c});
					}
				}
			}
		}
		
		
		System.out.println(bfs());

	}
	
	private static int bfs() {
		
		// 토마토가 처음부터 모두 익은 상태였다면
		if (tomatoQ.size() == H * N * M) return 0;
		
		while(!tomatoQ.isEmpty()) {
			int[] poll = tomatoQ.poll();
			int i = poll[0];
			int r = poll[1];
			int c = poll[2];
			
			for (int j = 0; j < 6; j++) {
				int ni = i + di[j];
				int nr = r + dr[j];
				int nc = c + dc[j];
				
				if (ni < 0 || ni >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if (boxes[ni][nr][nc] == 0) { // 안익은 토마토라면
					tomatoQ.offer(new int[] {ni, nr, nc});
					boxes[ni][nr][nc] = boxes[i][r][c] + 1;
				}
			}
		}
		
		int ans = Integer.MIN_VALUE;
		
		for (int i = 0; i < H; i++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (boxes[i][r][c] == 0) return -1;
					ans = Math.max(ans, boxes[i][r][c]);
				}
			}
		}
		
		// 그 이외의 경우는 최대 날짜 구해주기
		return ans - 1;
		
		
	}

}
