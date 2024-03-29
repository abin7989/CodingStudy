import java.io.*;
import java.util.*;

public class Main_10026_적록색약 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		char map[][] = new char[n][n];
		char rmap[][] = new char[n][n];
		boolean v[][] = new boolean[n][n];
		boolean rv[][] = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'G') {
					rmap[i][j] = 'R';
				} else {
					rmap[i][j] = map[i][j];
				}
			}
		}
		int cnt = 0;
		int cnt1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
					dfs(i, j,map, v, map[i][j]);
					cnt++;
				}
				if (!rv[i][j]) {
					dfs(i, j,rmap, rv, rmap[i][j]);
					cnt1++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(cnt1);

	}

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static void dfs(int x, int y, char map[][], boolean v[][], char pos) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != pos || v[nx][ny])
				continue;
			v[nx][ny] = true;
			dfs(nx, ny,map, v, pos);
		}
	}
}
