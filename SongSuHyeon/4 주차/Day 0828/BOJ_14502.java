import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

	static int N, M, max = Integer.MIN_VALUE;
	static int[] comb, res;
	static int[][] arr, copy;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static ArrayList<int[]> virus = new ArrayList<int[]>();

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					list.add(new int[] { i, j });
				if (arr[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}

		res = new int[list.size()]; // 조합 별 안전거리 저장할 배열

		copy = new int[N][M]; // 원본 배열 copy
		for (int i = 0; i < N; i++) {
			copy[i] = Arrays.copyOf(arr[i], M);
		}

		comb = new int[3];

		combination(0, 0);
		
		System.out.println(max);

	}

	private static void combination(int cnt, int start) {

		if (cnt == 3) {

			// 벽 세우기
			for (int i = 0; i < 3; i++) {
				int r = list.get(comb[i])[0];
				int c = list.get(comb[i])[1];
				arr[r][c] = 1;
			}

			bfs();

			// 원본값으로 되돌리기
			for (int i = 0; i < N; i++) {
				arr[i] = Arrays.copyOf(copy[i], M);
			}

			return;
		}

		for (int i = start; i < list.size(); i++) {
			comb[cnt] = i;
			combination(cnt + 1, i + 1);
		}

	}

	private static void p() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void bfs() {

		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < virus.size(); i++) {
			int r = virus.get(i)[0];
			int c = virus.get(i)[1];
			q.offer(new int[] { r, c });
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];

				if (check(nr, nc))
					continue;

				if (arr[nr][nc] == 0) {
					arr[nr][nc] = 2;
					q.offer(new int[] { nr, nc });
				}

			}

		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					cnt++;
			}
		}

		max = Math.max(max, cnt);

	}

	private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= M;
	}
}
