import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static int K;
	static int[] numbers; // 뽑은 수를 저장할 배열
	static int[] input; // 입력받은 수를 저장할 배열
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());

			if (K == 0)
				break;

			input = new int[K];
			numbers = new int[6];

			for (int i = 0; i < K; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);

			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {

		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < K; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}

	}

}
