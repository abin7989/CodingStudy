import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 레이저이면 : stick++ , cnt ++
 * 2. (( 연속이면 : stick++
 * 
 */

public class SWEA_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int stick = 0; // 쇠 막대기 수
			int cnt = 0; // 잘린 조각 개수

			String s = br.readLine();
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') { // 레이저가 나오면
					cnt += stick;
					i++;
				} else if (s.charAt(i) == '(' && s.charAt(i + 1)=='(') { // '((' 인 경우
					stick++;
				} else {
					cnt++;
					stick--;
				}
			}
			sb.append("#").append(test_case).append(" ").append(cnt+1).append("\n");
		}
		System.out.println(sb);
	}
}
