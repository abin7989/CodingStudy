import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.valueOf(br.readLine());
			int[][] arr = new int[N][N];
			int num = 1;
			int top = 0, bottom = N - 1, left = 0, right = N - 1;
			while (num <= N * N) {
				for (int j = left; j <= right; j++) {
					arr[top][j] = num;
					num++;
				}
				top++;
				for (int j = top; j <= bottom; j++) {
					arr[j][right] = num;
					num++;
				}
				right--;
				for (int j = right; j >= left; j--) {
					arr[bottom][j] = num;
					num++;
				}
				bottom--;
				for (int j = bottom; j >= top; j--) {
					arr[j][left] = num;
					num++;
				}
				left++;
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		}

	}
}
