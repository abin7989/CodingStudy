import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[15][15];

		for (int i = 0; i < 15; i++) {
			arr[0][i] = i;
			arr[i][1] = 1;
		}
		
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				arr[i][j] = arr[i][j-1] + arr[i - 1][j];
			}
		}
		
		
		for (int tc = 0; tc < T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());

			System.out.println(arr[K][N]);
		}

	}
}
