package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 1259. 팰린드롬수
public class Baekjoon_1259 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(1000);
		
		while(true) {
			String s = br.readLine();
			if (s.equals("0")) break;
			boolean flag = true;
			int num = s.length() / 2;
			for (int i = 0; i < num; i++) {
				if (s.charAt(i) != s.charAt(s.length() - 1 - i)) flag = false;
			}
			if (flag) sb.append("yes\n");
			else sb.append("no\n");
		}
		System.out.println(sb);
	}
	
}
