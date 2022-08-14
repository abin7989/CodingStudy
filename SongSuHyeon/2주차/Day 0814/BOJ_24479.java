import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_24479 {

	static int N, M, R, cnt = 1;
	static int[] visited;
	static ArrayList<Integer> graph[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점의 수 N (5 ≤ N ≤ 100,000)
		M = Integer.parseInt(st.nextToken()); // 간선의 수 M (1 ≤ M ≤ 200,000)
		R = Integer.parseInt(st.nextToken()); // 시작 정점 R (1 ≤ R ≤ N)

		visited = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			graph[i].sort(null);
		}

		DFS(R);

		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}

	}

	private static void DFS(int start) {
		visited[start] = cnt++;
		for (Integer d : graph[start]) {
			if (visited[d] > 0)
				continue;
			DFS(d);
		}
	}

}
