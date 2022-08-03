import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4698 {
	static int MAX_SIZE = 1000000;
	static int[] prime_arr = new int[MAX_SIZE+1];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime_arr[0] = 1;
		prime_arr[1] = 1;
		for (int i = 2; i <= Math.sqrt(MAX_SIZE); i++) {
			for (int j = i * 2; j <= MAX_SIZE; j += i) {
				prime_arr[j] = 1;
			}
		}
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String D = st.nextToken();
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());

			int[] arr = new int[(B - A) + 1];
			int num = A;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = num + i;
			}

			int cnt = 0;
			for (int i = A; i <= B; i++) {
				if (prime_arr[i] == 1)
					continue;
				if (String.valueOf(i).contains(D))
					cnt++;
			}

			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");

		} // end of test_case
		System.out.println(sb);
	} // end of main
} // end of class
