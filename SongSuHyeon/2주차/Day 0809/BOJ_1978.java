import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2581 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

		int MAX_SIZE = 1000;
		int[] isPrime = new int[MAX_SIZE + 1];
		isPrime[0] = 1;
		isPrime[1] = 1;
		for (int i = 2; i <= Math.sqrt(MAX_SIZE); i++) {
			for (int j = i * 2; j <= MAX_SIZE; j += i) {
				isPrime[j] = 1;
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (isPrime[arr[i]] == 0) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
