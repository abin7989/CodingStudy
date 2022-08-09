import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N-M+1];
		for (int i = 0, num = M; num <= N; i++, num++) {
			arr[i] = num;
		}

		int MAX_SIZE = 1000000;
		int[] isPrime = new int[MAX_SIZE + 1];
		isPrime[0] = 1;
		isPrime[1] = 1;
		for (int i = 2; i <= Math.sqrt(MAX_SIZE); i++) {
			for (int j = i * 2; j <= MAX_SIZE; j += i) {
				isPrime[j] = 1;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (isPrime[arr[i]] == 0) {
				sb.append(arr[i]).append("\n");
			}
		}

		System.out.println(sb);
	}

}
