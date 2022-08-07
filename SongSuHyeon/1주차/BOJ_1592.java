import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int L = Integer.valueOf(st.nextToken());

		int[] cnt = new int[N + 1]; // 각 사람 별 공을 받은 횟수
		cnt[1] = 1;
		int index = 1;
		int res = 0;
		while (true) {
			if (Arrays.stream(cnt).max().getAsInt() == M)
				break; // M번 공을 받은 사람이 있으면 종료

			if (cnt[index] % 2 == 0) { // 짝수일 때
				if (index - L > 0) {
					index -= L;
				} else {
					index = N + index - L;
				}
			} else { // 홀수일 때
				if (index + L > N) {
					index = index +L - N;
				} else {
					index += L;
				}
			}
			
			cnt[index]++;
			res++;
		}
		System.out.println(res);

	} // end of main
} // end of class
