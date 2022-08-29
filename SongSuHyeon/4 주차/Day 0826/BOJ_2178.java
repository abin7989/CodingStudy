import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	static int N, M;
	static int[][] map;
	static int[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] cs = s.toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = cs[j] - '0';
			}
		}

		bfs();

		System.out.println(visit[N - 1][M - 1]);

	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { 0, 0 });
		
		visit[0][0] = 1;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			int r = cur[0];
			int c = cur[1];
			
			if (r == N - 1 && c == M - 1)
				break;
			
			for (int d = 0; d < 4; d++) {
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (!check(nr, nc))
					continue;
				
				if (map[nr][nc] == 1 && visit[nr][nc] == 0) {
					que.offer(new int[] { nr, nc });
					visit[nr][nc] = visit[r][c] + 1;
				}
				
			}
			
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}