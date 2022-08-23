package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_7465 {

	static int T, N, M, cnt;
	static boolean[] visited;
	static ArrayList<Integer> graph[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			graph = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph[u].add(v);
				graph[v].add(u);
			}

			visited = new boolean[N + 1];

			cnt = 0;
			for (int i = 1; i < N + 1; i++) {
				if (DFS(i))
					cnt++;
				System.out.println();
			}
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static boolean DFS(int v) {

		System.out.print(v + " ");
		if(!visited[v]) {
			visited[v] = true;
			for (int i : graph[v]) {
				if (!visited[i]) {
					DFS(i);
				}
			}
			return true;
		}		
		return false;
	}
}
