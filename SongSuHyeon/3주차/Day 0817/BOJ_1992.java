import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.valueOf(s.charAt(j) - '0');
			}
		}

		check(n, 0, 0);

	}

	private static void check(int size, int r, int c) {

		int cmp = arr[r][c];
		boolean flag = true;
		Loop: for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (cmp != arr[i][j]) {
					flag = false;
					break Loop;
				}
			}
		}

		if (flag == true) {
			System.out.print(arr[r][c]);
			return;
		}

		int half = size / 2;

		System.out.print("(");
		check(half, r, c); // 1사분면
		check(half, r, c + half); // 2사분면
		check(half, r + half, c); // 3사분면
		check(half, r + half, c + half); // 4사분면
		System.out.print(")");
	}
}
