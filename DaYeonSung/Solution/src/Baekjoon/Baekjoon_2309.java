package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 2309. 일곱 난쟁이
public class Baekjoon_2309 {
	static int[] numbers, input;
	static boolean flag = false;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[9];
		numbers = new int[7];
		
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
		
		System.out.println(sb);
		
	}
	
	private static void comb(int cnt, int start) {
		
		if (flag) return;
		
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			if (sum == 100) {
				Arrays.sort(numbers);
				for (int i = 0; i < 7; i++) {
					sb.append(numbers[i]).append("\n");
				}
				flag = true;
				return;
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}
	
}
