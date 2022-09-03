import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167 {
	static int V, node;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static public class Node {
		int v;
		int weight;

		public Node(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}
	}

	static ArrayList<Node> graph[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 정점 번호

			while (true) {
				int v = Integer.parseInt(st.nextToken()); // 정점번호
				if (v == -1)
					break;
				int w = Integer.parseInt(st.nextToken()); // 거리

				graph[n].add(new Node(v, w));
			}
		}

		visited = new boolean[V+1];
		dfs(1,0);
		visited = new boolean[V+1];
		dfs(node,0);

		sb.append(max).append("\n");
		System.out.println(max);

	}

	private static void dfs(int v, int sum) {
		
		if(sum > max) {
			max = sum;
			node = v;
		}
		
		visited[v] = true; 

		for (Node a : graph[v]) {
			if (!visited[a.v]) {
				visited[a.v] = true;
				dfs(a.v, sum + a.weight);
			}
		}
	}
}
