import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15663 {

	static int N, M, before;
	static int[] input, numbers;
	private static LinkedHashSet<String> set = new LinkedHashSet<>();
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
		perm(0, 0);
		
		StringBuilder sb = new StringBuilder();
		for (String string : set) {
			sb.append(string).append("\n");
		}
		System.out.println(sb);

	}

	private static void perm(int cnt, int flag) {

		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int i : numbers) {
				sb.append(i).append(" ");
			}
			set.add(sb.toString());


			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			numbers[cnt] = input[i];
			perm(cnt + 1, flag | 1 << i);
		}

	}

}
