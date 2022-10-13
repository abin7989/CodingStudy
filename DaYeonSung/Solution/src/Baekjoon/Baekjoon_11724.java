package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11724. 연결 요소의 개수
public class Baekjoon_11724 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		
		System.out.println(cnt);
		
	}
	
	private static void dfs(int start) {
		visited[start] = true;
		
		for (int i = 1; i <= N; i++) {
			if (map[start][i] == 1 && !visited[i])
				dfs(i);
		}
	}

}
