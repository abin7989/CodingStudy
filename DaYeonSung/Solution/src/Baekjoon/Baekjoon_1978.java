package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1978. 소수 찾기
public class Baekjoon_1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 입력받을 수의 개수
		
		int primeCnt = 0;
		
		// 크기 N인 수 배열 입력 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // N번에 걸쳐서
			int num = Integer.parseInt(st.nextToken()); // 수 입력 받는다
			if (isPrime(num)) primeCnt++; // 소수라면 primeCnt 증가
		}
		
		System.out.println(primeCnt);
	}
	
	private static boolean isPrime(int n) { // 소수인지 판별해주는 함수
		if (n == 2) return true;
		
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) cnt++;
		}
		if (cnt == 2) return true;
		return false;
	}
	
}
