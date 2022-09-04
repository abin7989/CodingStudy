import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24480 {

	static int N, M, R, cnt = 1;
	static ArrayList<Integer> graph[];
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);

		}

		// 내림차순 정렬
		for (int i = 1; i < graph.length; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		visited = new int[N + 1];

		dfs(R);

		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}

	}

	private static void dfs(int v) {

		visited[v] = cnt++;

		for (Integer a : graph[v]) {
			if (visited[a] > 0)
				continue;
			dfs(a);
		}

	}

}
