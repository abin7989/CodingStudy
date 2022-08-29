import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {

	static int N, M, H, num = 1;
	static int[][][] arr;
	static boolean[][][] visited;
	static int[] dr = { -1, 0, 1, 0, 0, 0 };  // 상하좌우위아래
	static int[] dc = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static Queue<int[]> q = new LinkedList<int[]>();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][N][M];
		visited = new boolean[H][N][M];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
					if (arr[k][i][j] == 1) {
						q.offer(new int[] { k, i, j });
						visited[k][i][j] = true;
					}
				}
			}
		}

		bfs();

		int max = Integer.MIN_VALUE;
		loop1: for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				max = Math.max(Arrays.stream(arr[k][i]).max().getAsInt(), max);
				for (int j = 0; j < M; j++) {
					if (arr[k][i][j] == 0) {
						max = 0;
						break loop1;
					}
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

				for (int j = 0; j < 6; j++) {

					int nh = cur[0] + dh[j];
					int nr = cur[1] + dr[j];
					int nc = cur[2] + dc[j];

					if (check(nh, nr, nc))
						continue;

					if (!visited[nh][nr][nc] && arr[nh][nr][nc] != -1) {
						arr[nh][nr][nc] = num;
						visited[nh][nr][nc] = true;
						q.offer(new int[] { nh, nr, nc });
					}

				}

			}

		}
	}

	private static boolean check(int nh, int nr, int nc) {
		return nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M;
	}
}