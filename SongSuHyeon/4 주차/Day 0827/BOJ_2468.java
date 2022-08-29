import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {

	static int N, num;
	static int[] res;
	static int[][] map, copy;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			copy[i] = Arrays.copyOf(map[i], N);
		}

		res = new int[101];

		for (int level = 1; level <= 100; level++) {
			num = 1;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] < level)
						visited[i][j] = true;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						num++;
						bfs(i, j);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				map[i] = Arrays.copyOf(copy[i], N);
			}

			if (num == 2) {
				res[level] = 1;
			} else {
				res[level] = num - 1;
			}

			if (num - 1 == 0)
				break;
		}

		System.out.println(Arrays.stream(res).max().getAsInt());

	} // end of main

	private static void bfs(int r, int c) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });

		visited[r][c] = true;

		while (!q.isEmpty()) {

			int[] cur = q.poll();

			map[cur[0]][cur[1]] = num;
			for (int i = 0; i < 4; i++) {

				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] != 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}

			}

		}

	} // end of bfs

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

} // end of class