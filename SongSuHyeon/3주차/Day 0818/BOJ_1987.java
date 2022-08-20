<<<<<<< HEAD
package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {

	static int R, C, res;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static char[][] arr;
	static boolean[] ABC = new boolean[26];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		res = 1;
		DFS(0, 0, 0);

		System.out.println(res);

	}

	private static void DFS(int r, int c, int cnt) {
		if (ABC[arr[r][c] - 65]) {
			res = Math.max(res, cnt);
			return;
		}

		ABC[arr[r][c] - 65] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] >= 'A' && arr[nr][nc] <= 'Z') {
				DFS(nr, nc, cnt + 1);
			}

		}
		ABC[arr[r][c] - 65] = false;

	}

}
=======
package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {

	static int R, C, res;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static char[][] arr;
	static boolean[] ABC = new boolean[26];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		res = 1;
		DFS(0, 0, 0);

		System.out.println(res);

	}

	private static void DFS(int r, int c, int cnt) {
		if (ABC[arr[r][c] - 65]) {
			res = Math.max(res, cnt);
			return;
		}

		ABC[arr[r][c] - 65] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] >= 'A' && arr[nr][nc] <= 'Z') {
				DFS(nr, nc, cnt + 1);
			}

		}
		ABC[arr[r][c] - 65] = false;

	}

}
>>>>>>> dc83486dd99733575b3d2758d8d09f57a03259eb
