package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2665. 미로 만들기
public class Baekjoon_2665 {

	static int n;
	static int[][] map, visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new int[n][n];

		// 1은 흰 방, 0은 검은 방
		for (int r = 0; r < n; r++) {
			String str = br.readLine();
			for (int c = 0; c < n; c++) {
				map[r][c] = str.charAt(c) - '0';
				visited[r][c] = Integer.MAX_VALUE;
			}
		}
		
		blackToWhite();
		
		System.out.println(visited[n-1][n-1]);
	}
	
	private static void blackToWhite() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		visited[0][0] = 0;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int pollR = poll[0];
			int pollC = poll[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = pollR + dr[i];
				int nc = pollC + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
				
				if (visited[nr][nc] <= visited[pollR][pollC]) continue;
				
				if (map[nr][nc] == 1) { // 옮길 칸이 흰 방이면
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = visited[pollR][pollC];
				} else {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = visited[pollR][pollC] + 1;
				}
			}
		}
	}

}
