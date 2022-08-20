<<<<<<< HEAD
<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2117 {

	static int T, N, M, ans;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }; // CW
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // read end

			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j); // 각지점에서 K를 키워가면서 확인
				}
			}
			System.out.println("#" + t + " " + ans);
		}

	}

	private static void bfs(int rr, int cc) {

		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		int K = 1; // 서비스 범위
		int house = 0; // 범위내 집의수

		que.offer(new int[] { rr, cc }); // 시작지점
		visited[rr][cc] = true; // 방문

		while (!que.isEmpty()) {
			int size = que.size(); // K를 증가시키면서
									// 수입과 비용을 비교
			for (int i = 0; i < size; i++) { // 현지점에 집이 있나
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];

				if (map[r][c] == 1) {
					house++;
				}

				for (int d = 0; d < 4; d++) { // 현지점의 4방으로 증가
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!check(nr, nc))
						continue;

					if (!visited[nr][nc]) {
						que.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			// 같은 범위내에서 k에 따라 비용과 이익을 비교
			int cost = K * K + (K - 1) * (K - 1);
			int income = house * M;
			if (cost <= income) { // 적자만 안나면 됨
				ans = Math.max(ans, house);
			}
			K++;
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

=======
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2117 {

	static int T, N, M, ans;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }; // CW
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // read end

			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j); // 각지점에서 K를 키워가면서 확인
				}
			}
			System.out.println("#" + t + " " + ans);
		}

	}

	private static void bfs(int rr, int cc) {

		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		int K = 1; // 서비스 범위
		int house = 0; // 범위내 집의수

		que.offer(new int[] { rr, cc }); // 시작지점
		visited[rr][cc] = true; // 방문

		while (!que.isEmpty()) {
			int size = que.size(); // K를 증가시키면서
									// 수입과 비용을 비교
			for (int i = 0; i < size; i++) { // 현지점에 집이 있나
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];

				if (map[r][c] == 1) {
					house++;
				}

				for (int d = 0; d < 4; d++) { // 현지점의 4방으로 증가
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!check(nr, nc))
						continue;

					if (!visited[nr][nc]) {
						que.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			// 같은 범위내에서 k에 따라 비용과 이익을 비교
			int cost = K * K + (K - 1) * (K - 1);
			int income = house * M;
			if (cost <= income) { // 적자만 안나면 됨
				ans = Math.max(ans, house);
			}
			K++;
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

>>>>>>> dc83486dd99733575b3d2758d8d09f57a03259eb
=======
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2117 {

	static int T, N, M, ans;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }; // CW
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // read end

			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j); // 각지점에서 K를 키워가면서 확인
				}
			}
			System.out.println("#" + t + " " + ans);
		}

	}

	private static void bfs(int rr, int cc) {

		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		int K = 1; // 서비스 범위
		int house = 0; // 범위내 집의수

		que.offer(new int[] { rr, cc }); // 시작지점
		visited[rr][cc] = true; // 방문

		while (!que.isEmpty()) {
			int size = que.size(); // K를 증가시키면서
									// 수입과 비용을 비교
			for (int i = 0; i < size; i++) { // 현지점에 집이 있나
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];

				if (map[r][c] == 1) {
					house++;
				}

				for (int d = 0; d < 4; d++) { // 현지점의 4방으로 증가
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!check(nr, nc))
						continue;

					if (!visited[nr][nc]) {
						que.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			// 같은 범위내에서 k에 따라 비용과 이익을 비교
			int cost = K * K + (K - 1) * (K - 1);
			int income = house * M;
			if (cost <= income) { // 적자만 안나면 됨
				ans = Math.max(ans, house);
			}
			K++;
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

>>>>>>> dc83486dd99733575b3d2758d8d09f57a03259eb
}