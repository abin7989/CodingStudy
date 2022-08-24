package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 10026. 적록색약
public class Baekjoon_10026 {
	static char[][] grid;
	static boolean visited[][];	// 방문 체크
	static int N;
	
	static int[] dx = {0, -1, 0, 1}; // 상하좌우 x 
	static int[] dy = {-1, 0, 1, 0}; // 상하좌우 y
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		
		// 그리드 입력 받기
		for (int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		int normal = 0; // 정상인 구역의 수
		int RG = 0; // 적록색약인 구역의 수
		
		visited = new boolean[N][N];
		
		// 적록색약이 아닌 사람이 봤을 때 구역의 수 구하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					normal++;
				}
			}
		}
		
		// 적록색약 구역 수 구하기 위해 모든 G(초록) -> R(빨강) 변경
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (grid[i][j] == 'G') {
					grid[i][j] = 'R';
				}
			}
		}
		
		visited = new boolean[N][N];

		// 적록색약인 사람이 봤을 때 구역의 수 구하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					RG++;
				}
			}
		}
		
		sb.append(normal).append(" ").append(RG);
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true; // 현재 위치 방문 표시
		char color = grid[x][y]; // 현재 색깔
		
		for (int i = 0; i < dx.length; i++) { // 상 하 좌 우 4방향 체크
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 내에 있고
				if (grid[nx][ny] == color && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}
