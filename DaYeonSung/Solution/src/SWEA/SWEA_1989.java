package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 1989. 초심자의 회문 검사
public class SWEA_1989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int ans;
		
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			String str = br.readLine();
			String newStr = "";
			for (int i = str.length() - 1; i >= 0 ; i--) {
				newStr += str.charAt(i);
			}
			if (str.matches(newStr)) {
				ans = 1;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
}
