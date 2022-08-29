import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {

	static int T, N, cnt;
	static int[] dr = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] start;
	static int[][] arr;
	static boolean[][] visited;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());

			start = new int[2];
			arr = new int[N][N];
			visited = new boolean[N][N];

			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			visited[r][c] = true;

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;

			if(r == x && c == y) {
				cnt = 0;
			}
			else {
				bfs(r, c);
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;

			for (int t = 0; t < size; t++) {
				int[] cur = q.poll();

				for (int i = 0; i < 8; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];

					if (check(nr, nc))
						continue;

					if (arr[nr][nc] == 1) {
						return;
					}

					if (!visited[nr][nc]) {
						arr[nr][nc] = 3;
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}

				}

			}
		}
		q.clear();  // 중간에 끝내면 꼭 q 초기화 하기!!
	}

	private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= N;
	}
}