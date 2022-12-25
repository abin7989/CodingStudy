package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1240. 노드사이의 거리
public class Baekjoon_1240 {

	static int N, M;
	static ArrayList<int[]>[] nodes;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			nodes[start].add(new int[] {end, dist});
			nodes[end].add(new int[] {start, dist});
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(solve(start, end)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static int solve(int start, int end) {
		visited = new boolean[N + 1];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start, 0});
		visited[start] = true;
		
		int dist = 0;
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int next = poll[0];
			// 기저 조건
			if (end == next) {
				dist = poll[1];
				break;
			}
			
			for (int i = 0; i < nodes[next].size(); i++) {
				if (!visited[nodes[next].get(i)[0]]) {
					queue.offer(new int[] {nodes[next].get(i)[0], nodes[next].get(i)[1] + poll[1]});
					visited[nodes[next].get(i)[0]] = true;
				}
			}
		}
		
		return dist;
	}

}
