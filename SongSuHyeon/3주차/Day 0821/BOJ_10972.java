package day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972 {
	static int n;
	static int[] input, numbers; // 입력받은 수를 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		input = new int[n];
		numbers = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.valueOf(st.nextToken());
		}

		// 전철 : 순열에 쓰일 수들을 오름차순 정렬

		if (np(input)) {
			for (int i = 0; i < n; i++) {
				System.out.print(input[i] + " ");
			}
		} else {
			System.out.println("-1");
		}

	}

	private static boolean np(int[] numbers) {

		int N = numbers.length;

		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])  --i;
		if (i == 0)  return false;

		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])  --j;

		swap(numbers, i - 1, j);

		int k = N - 1;
		while (i < k)  swap(numbers, i++, k--);
		
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;

	}
}
