package Baekjoon;

import java.io.*;
import java.util.*;

// 백준 2667. 단지번호붙이기
public class Baekjoon_2667 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	static ArrayList<Integer> aparts = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		int ans = 0;
		
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && !visited[r][c]) {
					ans++;
					aparts.add(bfs(r, c));
				}
			}
		}
		
		int[] arr = new int[aparts.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = aparts.get(i);
		}
		
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(ans);
		System.out.println(sb);
		
	}
	
	private static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int pollR = poll[0];
			int pollC = poll[1];
			
			for (int i = 0; i < 4; i++) {
				int rr = pollR + dr[i];
				int cc = pollC + dc[i];
				if (rr < 0 || rr >= N || cc < 0 || cc >= N) continue;
				if (map[rr][cc] == 1 && !visited[rr][cc]) {
					cnt++;
					queue.offer(new int[] {rr, cc});
					visited[rr][cc] = true;
				}
			}
		}
		if (cnt == 0) return 1;
		return cnt;
	}

}
