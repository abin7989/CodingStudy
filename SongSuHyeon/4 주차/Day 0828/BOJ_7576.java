import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

	static int N, M, cnt, num = 1;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> q = new LinkedList<int[]>();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		bfs();

		int max = Integer.MIN_VALUE;
		loop1: for (int i = 0; i < M; i++) {
			max = Math.max(Arrays.stream(arr[i]).max().getAsInt(), max);
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					max = 0;
					break loop1;
				}
			}
		}

		System.out.println(max - 1);

	}

	private static void bfs() {

		while (!q.isEmpty()) {
			int size = q.size();
			num++;
			for (int t = 0; t < size; t++) {
				int[] cur = q.poll();

				for (int i = 0; i < 4; i++) {

					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];

					if (check(nr, nc))
						continue;

					if (!visited[nr][nc] && arr[nr][nc] != -1) {
						arr[nr][nc] = num;
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });

					}

				}
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= M || nc < 0 || nc >= N;
	}
}