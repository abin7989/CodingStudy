import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
	static int N, M;
	static int[] input, numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		numbers = new int[M];
		isSelected = new boolean[N];

		for (int i = 1; i <= N; i++) {
			input[i - 1] = i;
		}

		perm(0);

	}

	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i];
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}

	}

}
