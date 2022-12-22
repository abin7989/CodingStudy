package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1543. 문서 검색
public class Baekjoon_1543 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String doc = br.readLine();
		String target = br.readLine();
		
		int docLen = doc.length();
		int targetLen = target.length();
		
		doc = doc.replace(target, "");
		System.out.println((docLen - doc.length()) / targetLen);

	}

}
