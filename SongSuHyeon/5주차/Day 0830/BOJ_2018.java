import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2018 {
	
	/*
	 * sum == N 이면 cnt++, end++, sum값 변경
	 * sum > N 이면 sum값 변경, start++
	 * sum < N 이면 end++, sum값 변경
	 */
	static int cnt = 1, N;
	static int[] arr;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		int start = 1;
		int end = 1;
		int sum = 1;

		while (end != N) {
			if (sum == N) {
				cnt++;
				end++;
				sum = sum + end;
			} else if (sum > N) {
				sum = sum - start;
				start++;

			} else if (sum < N) {
				end++;
				sum = sum + end;
			}
		}
		System.out.println(cnt);
	}

}
