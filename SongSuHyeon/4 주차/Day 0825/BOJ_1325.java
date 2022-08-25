package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {

	static int[] res;
	static boolean[] visited;
	static ArrayList<Integer> graph[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		res = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			bfs(i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, res[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (res[i] == max)
				System.out.print(i + " ");
		}
	} // end of main

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		visited[start] = true;
		while (!queue.isEmpty()) {

			int cur = queue.poll();

			for (int a : graph[cur]) {
				if (visited[a] == false) {
					visited[a] = true;
					res[a]++;
					queue.add(a);
				}
			}
		}
	} // end of bfs

} // end of class
