package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 2007. 패턴 마디의 길이
public class SWEA_2007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 수만큼 반복
			String str = br.readLine(); // 문자열 입력 받기
			
			for (int i = 1; i <= str.length(); i++) {
				String str1 = str.substring(0, i); // 0번째부터 i-1 번째 단어까지 자르기
				String str2 = str.substring(i, i + i); // i번째부터 2i-1 번째 단어까지 자르기
				if (str1.equals(str2)) { // 일치하면
					sb.append("#").append(tc).append(" ").append(str1.length()).append("\n"); // 마디 길이 출력
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
