import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.valueOf(br.readLine());
			int[] a = new int[N];
			int[] b = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				a[i] = Integer.valueOf(st.nextToken());
				b[i] = Integer.valueOf(st.nextToken());
			}

			int P = Integer.valueOf(br.readLine());
			int[] c = new int[P];
			for (int i = 0; i < P; i++) {
				c[i] = Integer.valueOf(br.readLine());
			}

			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < P; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (c[i] >= a[j] && c[i] <= b[j])
						cnt++;
				}
				sb.append(cnt).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}
}
