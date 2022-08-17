import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author suhyeon
 * 인접 리스트에 그래프 저장
 * ex) 1 -> 2 3 4
 * 	   2 -> 4 1
 *     3 -> 4 1
 *     4 -> 1 2 3
 */

public class BOJ_1260 {

	static int N, M, V;
	static boolean[] visited;
	static ArrayList<Integer> graph[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

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

		// 번호가 작은 것 먼저 방문하기 위해 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		DFS(V);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(V);
		System.out.println();

	}

	static void DFS(int v) {
		System.out.print(v + " ");
		visited[v] = true;
		for (int i : graph[v]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int now_Node = queue.poll();
			System.out.print(now_Node + " ");
			for (int i : graph[now_Node]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
