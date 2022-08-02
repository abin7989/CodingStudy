import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.valueOf(br.readLine());
			int[][] arr = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= i; j++) {
					if (j == 1 || j == i) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}
				}
			}
			
			System.out.println("#" + test_case);
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr.length; j++) {
					if(arr[i][j]!=0) {
						System.out.print(arr[i][j] +" ");
					}
				}
				System.out.println();
			}

		}

	} // end of main
} // end of class

