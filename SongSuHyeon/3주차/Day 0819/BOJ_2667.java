import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 연결 된 방의 번호를 바꾸고 개수 세기
   0 2 2 0 3 0 0
   0 2 2 0 3 0 3 
   2 2 2 0 3 0 3 
   0 0 0 0 3 3 3
   0 4 0 0 0 0 0
   0 4 4 4 4 4 0 
   0 4 4 4 0 0 0
 */


public class BOJ_2667 {

	static int N, num = 1;
	static int[] res = new int[1000];
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		visited = new boolean[N][N];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					num++;
					dfs(i, j);
				}
			}
		}


		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				if (arr[i][j] != 0) {
					res[arr[i][j]]++;
				}
			}
		}


		int cnt = 0;
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				cnt++;
			}
		}

		sb.append(cnt).append("\n");
		
		Arrays.sort(res);
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				sb.append(res[i]).append("\n");
			}
		}

		System.out.println(sb);

	}

	private static void dfs(int r, int c) {

		visited[r][c] = true;
		arr[r][c] = num;

		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (!visited[nr][nc] && arr[nr][nc] == 1) {
					visited[nr][nc] = true;
					arr[nr][nc] = num;

					dfs(nr, nc);
				}
			}

		}

		visited[r][c] = false;

	}

}
