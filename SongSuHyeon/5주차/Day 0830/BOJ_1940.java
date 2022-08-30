import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {

	static int N, M, cnt;
	static int[] arr;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 재료의 개수
		M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수

		arr = new int[N]; // 재료들이 가진 고유한 번호
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int start = 0;
		int end = N - 1;
		int sum = 0;

		while (start < end) {
			if (arr[start] + arr[end] < M) {
				start++;
			} else if (arr[start] + arr[end] > M) {
				end--;
			} else if (arr[start] + arr[end] == M) {
				cnt++;
				start++;
				end--;
			}
		}
		System.out.println(cnt);
	} // end of main

} // end of class
