package day0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644 {

	static boolean flag = false;
	static int N, M, A, B, res;
	static boolean[] visited;
	static ArrayList<Integer> graph[];

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N +1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}
		
		dfs(A, 0);
		
		if(flag)
			System.out.println(res);
		else
			System.out.println("-1");
	}

	private static void dfs(int v, int cnt) {

		if(v == B) {
			res = cnt;
			flag = true;
			return;
		} 
		
		visited[v] = true;

		for (Integer a : graph[v]) {
			if (!visited[a])
				dfs(a, cnt + 1);
		}
		
	}

}
