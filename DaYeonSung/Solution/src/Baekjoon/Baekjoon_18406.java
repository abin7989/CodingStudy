package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 18406. 럭키 스트레이트
public class Baekjoon_18406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String str1 = str.substring(0, str.length() / 2);
		String str2 = str.substring(str.length() / 2, str.length());
		
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 0; i < str1.length(); i++) {
			sum1 += str1.charAt(i) - '0';
		}
		
		for (int i = 0; i < str2.length(); i++) {
			sum2 += str2.charAt(i) - '0';
		}
		
		if (sum1 == sum2) System.out.println("LUCKY");
		else System.out.println("READY");
	}
}
