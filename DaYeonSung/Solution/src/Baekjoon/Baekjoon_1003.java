package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1003. 피보나치 함수
public class Baekjoon_1003 {

	static int zero, one, sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(zero).append(' ').append(one).append('\n');
		}
		
		System.out.println(sb);

	}
	
	private static void fibonacci(int N) {
		zero = 1;
		one = 0;
		sum = 1;
		
		for (int i = 0; i < N; i++) {
			zero = one;
			one = sum;
			sum = zero + one;
		}
	}

}
