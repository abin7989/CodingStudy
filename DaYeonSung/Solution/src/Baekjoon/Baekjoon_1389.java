package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1389. 케빈 베이컨의 6단계 법칙
public class Baekjoon_1389 {

	static int N, M;
	static int[][] rels;
	static boolean[] visited;
	static int[] kevin;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		rels = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			rels[r1][r2] = 1;
			rels[r2][r1] = 1;
		}
		
		kevin = new int[N+1];
		
		
		for (int r = 1; r <= N; r++) {
			visited = new boolean[N+1];
			kevin[r] = findKevin(r);
		}
		
		int minKevin = Integer.MAX_VALUE;
		int minKevinIdx = 0;
		
		for (int i = N; i > 0; i--) {
			if (kevin[i] <= minKevin) {
				minKevin = kevin[i];
				minKevinIdx = i;
			}
		}
		
		System.out.println(minKevinIdx);
		
	}

	
	private static int findKevin(int user) {
		int sum = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		visited[user] = true; // 자기 자신은 true 처리
		queue.offer(new int[] {user, 0});
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			sum += poll[1];
		
			for (int i = 1; i <= N; i++) {
				if (rels[poll[0]][i] == 1 && visited[i] == false) {
					visited[i] = true;
					queue.offer(new int[] {i, poll[1] + 1});
				}
			}
		}
		
		return sum;
	}
}