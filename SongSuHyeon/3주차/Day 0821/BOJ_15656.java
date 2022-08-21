import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656 {

	static int N, M;
	static int[] input, numbers;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		numbers = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		perm(0);
		System.out.println(sb);

	}

	private static void perm(int cnt) {

		if (cnt == M) {
			for (int i : numbers) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			numbers[cnt] = input[i];
			perm(cnt + 1);
		}

	}

}
