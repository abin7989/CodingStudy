package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11050. 이항 계수 1
public class Baekjoon_11050 {

	static int N, R, totalCnt;
	static int[] input, numbers;
	public static void main(String[] args) throws Exception {
		// nCr = n-1Cr-1 + n-1Cr
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		totalCnt = 0;
		
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		
		combi(0, 0);
		
		System.out.println(totalCnt);
		
	}
	
	private static void combi(int cnt, int start) {
		if (cnt == R) {
			totalCnt++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combi(cnt + 1, i + 1);
		}
	}

}