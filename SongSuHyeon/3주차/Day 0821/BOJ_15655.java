import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655 {

	static int N, M;
	static int[] input, numbers;
	static StringTokenizer st;

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
		comb(0, 0);

	}

	private static void comb(int cnt, int start) {

		if (cnt == M) {
			for (int i : numbers) {
				System.out.print(i + " ");
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
