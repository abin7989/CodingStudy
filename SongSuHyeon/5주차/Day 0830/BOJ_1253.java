import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {

	static int N, cnt;
	static long[] arr;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // N개의 수

		arr = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			long find = arr[i];
			int start = 0;
			int end = N - 1;

			while (start < end) {

				if (arr[start] + arr[end] == find) {

					// find는 서로 다른 두 수의 합
					if (start != i && end != i) {
						cnt++;
						break;
					} else if (start == i) {
						start++;
					} else if (end == i) {
						end--;
					}
				} else if (arr[start] + arr[end] < find)
					start++;
				else
					end--;
			}
		}
		System.out.println(cnt);
	} // end of main

} // end of class
