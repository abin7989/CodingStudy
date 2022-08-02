package day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		int N = Integer.valueOf(br.readLine());
		int[][] farm = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				farm[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}

		int half = (int) ((double) farm.length / 2.0);
		int cnt = 1;
		int sum = 0;
		int left = half;
		int right = N - 1;
		for (int i = 0; i < farm.length; i++) {
			if (i <= half) {
				for (int j = left; j < left + 2 * i + 1; j++) {
					sum += farm[i][j];
					System.out.println(farm[i][j]);
				}
				left--;
			} else
				break;
		}
		System.out.println("=============");
		for (int i = 0; i < farm.length; i++) {
			left++;
			right--;
			if (i > half) {
				for (int j = left; j < right; j++) {
					sum += farm[i][j];
					System.out.println(farm[i][j]);
				}
			}
			else continue;
		}

		System.out.println(sum);

	}
}
