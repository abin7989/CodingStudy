import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, max;
	static int[] src, map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			max = 0;

			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			src = new int[N];
			map = new int[N];
			visit = new boolean[N];

			for (int i = 0; i < N; i++)
				src[i] = Integer.parseInt(st.nextToken());
			perm(0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");

		}
		FileWriter os = new FileWriter("t.txt");
		os.write(sb.toString());
		os.close();
		System.out.println(sb);
	}

	public static void perm(int cnt) {
		if (cnt == N) {
			calculator(0, 0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			map[cnt] = src[i];
			perm(cnt + 1);
			visit[i] = false;
		}
	}
	public static void calculator(int i, int cnt, int lsum, int rsum) {
		if (cnt == N) {
			max++;
			return;
		}
		calculator(i + 1, cnt + 1, lsum + map[i], rsum);
		if (lsum >= rsum + map[i])
			calculator(i + 1, cnt + 1, lsum, rsum + map[i]);
	}
}
