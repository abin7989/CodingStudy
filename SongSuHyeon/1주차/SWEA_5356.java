import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5356 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int max_length = 0;
			char[][] s = new char[5][15];
			for (int line = 0; line < 5; line++) {
				String tmp = br.readLine();
				if(max_length < tmp.length()) max_length = tmp.length();
				for (int j = 0; j < tmp.length(); j++) {
					s[line][j] = tmp.charAt(j);
				}
			}
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < max_length; i++) {
				for (int j = 0; j < 5; j++) {
					if(s[j][i] != '\u0000') sb.append(s[j][i]);
				}
			}
			sb.append("\n");
		}  // end of test_case
		System.out.println(sb);
	}  // end of main
}  // end of class
