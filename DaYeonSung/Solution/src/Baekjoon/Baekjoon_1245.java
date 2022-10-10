package Baekjoon;

import java.io.*;
import java.util.*;

// 백준 1245. 농장 관리
public class Baekjoon_1245 {

	static int N, M;
	static int[][] farm;
	static boolean[][] visited;
	static boolean flag;
	static int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		farm = new int[N][M];
		visited = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				farm[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c]) {
					flag = true;
					dfs(r, c);
					if (flag) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int i = 0; i < 8; i++) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			if (rr < 0 || rr >= N || cc < 0 || cc >= M) continue;
			
			if (farm[rr][cc] > farm[r][c]) flag = false; // 주변에 나보다 높은 봉우리가 있으면 false 처리 (여긴 꼭대기가 X)
			if (!visited[rr][cc] && farm[rr][cc] == farm[r][c]) {
				dfs(rr, cc);
			}
		}
		
	}

}