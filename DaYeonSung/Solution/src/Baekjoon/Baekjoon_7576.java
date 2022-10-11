package Baekjoon;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 백준 7576. 토마토
public class Baekjoon_7576 {

	static int M, N, maxDay = Integer.MIN_VALUE;
	static int[][] box;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if (box[r][c] == 1) { // 입력된 토마토가 익은 토마토라면
					queue.add(new int[] {r, c}); // 큐에 넣기
				}
			}
		}
		
		
		// 입력:
		// 1은 익은 토마토
		// 0은 익지 않은 토마토
		// -1은 토마토가 들어있지 않은 칸
		
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int pollR = poll[0];
			int pollC = poll[1];
			
			for (int i = 0; i < 4; i++) {
				int rr = pollR + dr[i];
				int cc = pollC + dc[i];
				if (rr < 0 || rr >= N || cc < 0 || cc >= M) continue;
				if (box[rr][cc] == 0) {
					box[rr][cc] = 1;
					queue.offer(new int[] {rr, cc});
					box[rr][cc] = box[pollR][pollC] + 1;
				}
			}
		}
		
		// 최대 날짜 구하기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 0) return -1; // 토마토가 모두 익지 못하는 상황이라면 -1 리턴
				if (box[r][c] > maxDay) maxDay = box[r][c]; // 날짜 최댓값 구하기
			}
		}
		
		if (maxDay == 1) return 0; // 저장될 때부터 모든 토마토가 익어있는 상태라면 0 리턴
		
		return maxDay - 1;
	}

}
