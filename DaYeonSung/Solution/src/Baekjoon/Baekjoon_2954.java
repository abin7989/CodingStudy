package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2954. 창영이의 일기장
public class Baekjoon_2954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine(); // 문자열 입력받기
		int len = str.length(); // 문자열 길이 변수
		
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') { // 문자열을 훑다가 모음을 맞닥뜨리면
				sb.append(str.charAt(i)); // 그 모음 하나만 스트링빌더에 append하고
				i += 2; // 인덱스 2개 건너뛰기
			} else { // 이외의 경우에는
				sb.append(str.charAt(i)); // 스트링빌더에 해당 위치 문자 append
			}
		}
		
		System.out.println(sb); // 스트링빌더 출력

	}

}
