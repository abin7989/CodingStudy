import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.valueOf(br.readLine());
			int[][] farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}

			int half = (int) ((double) farm.length / 2.0);
			int sum = 0;
			int left = half;
			int right = N - 1;
			for (int i = 0; i <= half; i++) {
				for (int j = left; j < left + 2 * i + 1; j++) {
					sum += farm[i][j];
				}
				left--;
			}
			left = 0;
			for (int i = half + 1; i < farm.length; i++) {
				left++;
				right--;
				for (int j = left; j <= right; j++) {
					sum += farm[i][j];
				}
			}
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}