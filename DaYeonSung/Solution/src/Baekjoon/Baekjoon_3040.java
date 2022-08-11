package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 3040. 백설 공주와 일곱 난쟁이
public class Baekjoon_3040 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] nums = new int[9];
		int sum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}
		
		int fake1 = 0;
		int fake2 = 0;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (sum - nums[i] - nums[j] == 100) {
					fake1 = i;
					fake2 = j;
				}
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i != fake1 && i != fake2) {
				sb.append(nums[i]).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
