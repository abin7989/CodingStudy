import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1947 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		long mod = 1000000000;
		long[] arr = new long[1000001];
		arr[1] = 0;
		arr[2] = 1;
		for (int i = 3; i <= N; i++) {
			arr[i] = (i - 1) * (arr[i - 1] + arr[i - 2]) % mod;
		}
		System.out.println(arr[N]);
	}

}
