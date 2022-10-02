package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 9012. 괄호
public class Baekjoon_9012 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력 받기
		
		for (int tc = 0; tc < T; tc++) { // 테스트 케이스 수(T)만큼 반복
			String str = br.readLine(); // 괄호 문자열 입력 받기
			int open = 0; // 열린 괄호 갯수
			int close = 0; // 닫힌 괄호 갯수
			for (int i = 0; i < str.length(); i++) { // 문자열을 훑으면서
				if (str.charAt(i) =='(') { // 열린 괄호를 만나면
					open++; // 열린 괄호 갯수 늘리기
				} else if (str.charAt(i) == ')') { // 닫힌 괄호를 만나고
					if (open > 0) open--; // 열린 괄호가 1개 이상이면 열린 괄호 갯수를 하나 줄이기
					else close++; // 열린 괄호가 0개라면 닫힌 괄호 갯수만 늘리기
				}
			}
			if (open != 0) sb.append("NO\n"); // 열린 괄호 갯수가 0이 아니라면 VPS가 아니다
			else if (close != 0) sb.append("NO\n"); // 닫힌 괄호 갯수도 0이 아니라면 VPS가 아니다
			else { // open과 close가 둘 다 0이어야
				sb.append("YES\n"); // VPS로 판단
			}
		}
		System.out.println(sb);
		
	}
	
}
