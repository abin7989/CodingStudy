package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1012. 유기농 배추
public class Baekjoon_1012 {

	static int M, N, K;
	static int[][] map;
	static boolean[][] checked;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			checked = new boolean[M][N];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
			}
			
			int cnt = 0; // 지렁이 개수 변수
			
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1 && !checked[r][c]) {
						bfs(r, c);
						// 인접한 곳을 모두 파악했으면 지렁이 1마리 추가
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
			
			
		}
		System.out.println(sb);
		
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {r, c}); // 루트 노드 설정
		
		checked[r][c] = true; // 시작 좌표엔 배추가 있으니 true로 바꿔주기
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			for (int i = 0; i < 4; i++) { // 상 하 좌 우 4번
				int x = poll[0] + dr[i];
				int y = poll[1] + dc[i];
				
				if (x < 0 || x >= M || y < 0 || y >= N) { // 좌표가 배추밭 벗어나면
					continue; // continue 처리
				}
				
				if (map[x][y] == 1 && !checked[x][y]) {
					queue.offer(new int[] {x, y}); // 좌표 저장
					checked[x][y] = true; // 체크 표시
				}
			}
		}
		
	}

}