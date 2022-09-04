import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2210 {

	static String[][] arr;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new String[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				arr[i][j] = st.nextToken();
			}
		}

		set = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, arr[i][j]);
			}
		}
		System.out.println(set.size());
	}

	private static void dfs(int i, int j, int cnt, String s) {
		if (cnt == 5) {
			set.add(s);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if (check(nr, nc))
				continue;

			dfs(nr, nc, cnt + 1, s + arr[nr][nc]);
		}

	}

	private static boolean check(int nr, int nc) {
		return nr < 0 || nr >= 5 || nc < 0 || nc >= 5;
	}

}
