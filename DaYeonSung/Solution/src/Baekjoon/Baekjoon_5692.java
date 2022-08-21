package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 5692. 팩토리얼 진법
public class Baekjoon_5692 {
	static int fact (int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * fact(n-1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String N = br.readLine();
			int len = N.length();
			
			int newNumber = 0;
			
			if (N.equals("0")) break;
			
			for (int i = 0; i < len; i++) {
				newNumber += (N.charAt(i) - '0') * fact(len - i);
			}
			
			sb.append(newNumber).append("\n");
		}
		
		System.out.println(sb);
	}
}
