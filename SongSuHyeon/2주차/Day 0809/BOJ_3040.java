package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9];
		int sum = 0, num = 0;
		for (int i = 0; i < 9; i++) {
			num = Integer.valueOf(br.readLine());
			sum += num;
			arr[i] = num;

		}

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (100 == sum - arr[i] - arr[j]) {
					arr[i] = -1;
					arr[j] = -1;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			if (arr[i] != -1) {
				System.out.println(arr[i]);
			}
		}
	}
}