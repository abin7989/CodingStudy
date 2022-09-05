package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2609. 최대공약수와 최소공배수
public class Baekjoon_2609 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int smaller = N <= M ? N : M;
		int bigger = N <= M ? M : N;
		
		int gcd = GCD(bigger, smaller);
		System.out.println(gcd);
		System.out.println(LCM(N, M, gcd));
		
	}
	
	// 최대공약수 구하기
	private static int GCD(int N, int M) {
		int smaller = N <= M ? N : M;
		
		while (M > 0) {
			int tmp = N;
			N = M;
			M = tmp % M;
		}
		
		
		return N;
	}
	
	// 최소공배수 구하기
	private static int LCM(int N, int M, int gcd) {
		int ans = 1;
		ans *= (gcd * (N / gcd) * (M / gcd));
		
		return ans;
	}
}
