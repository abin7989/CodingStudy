import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2606 {

	static int N, P, cnt; // 컴퓨터의 수 N (1<= N<=100), 컴퓨터 쌍의 수 P
	static boolean[] visited;
	static ArrayList<Integer> graph[];
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);

		}

		visited = new boolean[N + 1];
		DFS(1);
		System.out.println(cnt);

	}

	private static void DFS(int v) {

		visited[v] = true;
		for (int i : graph[v]) {
			if (!visited[i]) {
				cnt++;
				DFS(i);
			} else {
				continue;
			}
		}

	}

}
