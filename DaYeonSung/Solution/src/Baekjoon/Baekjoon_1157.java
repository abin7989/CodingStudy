package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1157. 단어 공부
public class Baekjoon_1157 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toUpperCase();
		
		int[] cnts = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - 'A';
			cnts[num]++;
		}
		
		int maxCnt = 0;
		char maxWord = '?';
		
		for (int i = 0; i < cnts.length; i++) {
			if (maxCnt < cnts[i]) {
				maxCnt = cnts[i];
				maxWord = (char)(i + 'A');
			} else if (maxCnt == cnts[i]) {
				maxWord = '?';
			}
		}
		
		System.out.println(maxWord);
	}
	
}
