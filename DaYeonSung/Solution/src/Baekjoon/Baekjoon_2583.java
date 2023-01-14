package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2583. 영역 구하기
public class Baekjoon_2583 {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int r = y1; r < y2; r++) {
				for (int c = x1; c < x2; c++) {
					visited[r][c] = true;
				}
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> areas = new ArrayList<>();
		
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					cnt++;
					int area = start(r, c);
					areas.add(area);
				}
			}
		}
		
		Collections.sort(areas);
		
		sb.append(cnt).append("\n");
		
		for (int i = 0; i < cnt; i++) {
			sb.append(areas.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
		
	}
	
	private static int start(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		int area = 1;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int pollR = poll[0];
			int pollC = poll[1];
			
			
			for (int i = 0; i < 4; i++) {
				int nr = pollR + dr[i];
				int nc = pollC + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				
				if (!visited[nr][nc]) {
					queue.offer(new int[] {nr, nc});
					area++;
					visited[nr][nc] = true;				
				}
			}
		}
		
		return area;
	}

}
