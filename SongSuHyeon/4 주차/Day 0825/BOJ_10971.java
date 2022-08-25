import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {

	static int N, res;
	static int[][] W;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		W = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			dfs(i, i, 0, 0);
		}

		System.out.println(min);

	}

	private static void dfs(int start, int now, int cnt, int cost) {
		if (now == start && cnt == N) {
			min = Math.min(min, cost);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(W[now][i] == 0) continue;

			if (!visited[i] && W[now][i] > 0) {
				visited[i] = true;
				cost += W[now][i];
				dfs(start, i, cnt + 1, cost);
				cost -= W[now][i];
				visited[i] = false;
			}

		}

	}
}