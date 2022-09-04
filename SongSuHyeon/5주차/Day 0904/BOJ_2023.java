import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023 {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());

		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);

		System.out.println(sb);

	}

	private static void dfs(int num, int len) {
		if (len == N) {
			if (isPrime(num))
				sb.append(num).append("\n");
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (i == 2 || i == 4 || i == 6 || i == 8)
				continue;

			if (isPrime(num * 10 + i))
				dfs(num * 10 + i, len + 1);
		}

	}

	private static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}