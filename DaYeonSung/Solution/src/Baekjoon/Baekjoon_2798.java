package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2798. 블랙잭
public class Baekjoon_2798 {

	static int N, M;
	static int max = Integer.MIN_VALUE;
	static int[] numbers, input;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		numbers = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		
		System.out.println(max);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			int sum = numbers[0] + numbers[1] + numbers[2];
			if (sum <= M && max < sum) {
				max = sum;
				return;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
	
}
