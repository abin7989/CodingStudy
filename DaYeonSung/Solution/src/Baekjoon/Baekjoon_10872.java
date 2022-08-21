package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 10872. 팩토리얼
public class Baekjoon_10872 {

	static int fact (int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * fact(n-1);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fact(N));

	}

}
