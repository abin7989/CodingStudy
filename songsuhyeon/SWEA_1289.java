import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SWEA_1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			char[] before = new char[s.length()];  // 0으로 초기화
			Arrays.fill(before, '0');
 
			
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != before[i]) {  // 비교
					Arrays.fill(before, i, s.length(), (before[i] == '1') ? '0' : '1');
					cnt++;
				}
				if (s.equals(String.valueOf(before))) {
					System.out.println("#" + test_case + " " + cnt);
					break;
				}

			}
		}

	}
}
