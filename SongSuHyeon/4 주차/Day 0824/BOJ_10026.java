import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {

	static int N, cnt1, cnt2;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new char[N + 1][];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			arr[i] = s.toCharArray();
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, arr[i][j]);
					cnt1++;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 'G')
					arr[i][j] = 'R';
				
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, arr[i][j]);
					cnt2++;
				}
			}
		}

		System.out.println(cnt1 + " " + cnt2);

	}

	private static void dfs(int r, int c, char color) {

		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// arr 범위를 벗어나지 않고 같은 색이면
			if (check(nr, nc) && !visited[nr][nc] && color == arr[nr][nc]) {
				dfs(nr, nc, color);
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 & nr < N && nc >= 0 & nc < N;
	}

	private static void p() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");

			}
			System.out.println();
		}

	}

}
