import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
	static int N, M;
	static int[] input, numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		numbers = new int[M];

		for (int i = 1; i <= N; i++) {
			input[i - 1] = i;
		}

		comb(0, 0);

	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}

	}

}
