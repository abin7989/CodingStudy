import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7964 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.valueOf(st.nextToken());
			int D = Integer.valueOf(st.nextToken());

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N + 2];
			arr[0] = 1;
			arr[N + 1] = 1;
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.valueOf(st2.nextToken());
			}

			int d = D, cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 1) {
					d = D;
				} else if (arr[i] == 0 && d == 1) { // 다시 세움
					cnt++;
					d = D;
				} else {
					d--;
				}

			}
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
