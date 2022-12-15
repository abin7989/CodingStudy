package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1253. 좋다
public class Baekjoon_1253 {

	static int N, cnt;
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 수의 개수
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		cnt = 0;
		for (int i = 0; i < N; i++) {
			isItGood(i);
		}
		
		System.out.println(cnt);
		
	}
	
	private static void isItGood(int idx) {
		int start = 0;
		int end = N - 1;
		
		while(start < end) {
			if (start == idx) start++;
			else if (end == idx) end--;
			
			else {
				if (nums[idx] > nums[start] + nums[end]) start++; // 목표값보다 합이 작을 때
				else if (nums[idx] == nums[start] + nums[end]) {
					cnt++;
					return;
				} else { // 목표값보다 합이 작을 때
					end--;
				}
			}
		}
	}

}
