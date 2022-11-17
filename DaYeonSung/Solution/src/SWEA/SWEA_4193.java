package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 4193. 수영대회 결승전
public class SWEA_4193 {

	static int N, A, B, C, D;
	static int[][] pool;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 }; // 상 하 좌 우
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 수영장의 크기
			
			pool = new int[N][N];
			visited = new boolean[N][N];
			
			// 수영장 입력 받기
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					pool[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작 위치
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			// 도착 위치
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			int ans = swim();
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);

	}
	
	private static int swim() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {A, B, 0});
		visited[A][B] = true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int pr = poll[0];
			int pc = poll[1];
			int ptime = poll[2];
			
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue; // 이미 방문했거나 경계 벗어나면 스킵
				
				if (pool[nr][nc] == 1) continue; // 장애물 만나면 스킵
				
				if (nr == C && nc == D) {
					return ptime + 1;
				}
				
				if (pool[nr][nc] == 2) { // 소용돌이 구간 만나면
					// 시간 판별
					if (ptime % 3 == 2) {
						queue.offer(new int[] {nr, nc, ptime + 1});
						visited[nr][nc] = true;
					} else {
						queue.offer(new int[] {pr, pc, ptime + 1});
						visited[pr][pc] = true;
					}
					
				} else {
					queue.offer(new int[] {nr, nc, ptime + 1});
					visited[nr][nc] = true;
				}
			}
		}
		return -1;
		
	}

}
