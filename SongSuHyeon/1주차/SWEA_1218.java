import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int[] cnt = new int[8];
			int T = Integer.valueOf(br.readLine());
			String s = br.readLine();
			
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
				case '(':
					cnt[0]++;
					break;
				case ')':
					cnt[1]++;
					break;
				case '[':
					cnt[2]++;
					break;
				case ']':
					cnt[3]++;
					break;
				case '{':
					cnt[4]++;
					break;
				case '}':
					cnt[5]++;
					break;
				case '<':
					cnt[6]++;
					break;
				case '>':
					cnt[7]++;
					break;
				}
			}
			boolean check = true;  // 괄호 짝이 맞으면
			for (int i = 0; i < 8; i+=2) {
				if(cnt[i] != cnt[i+1]) {
					check = false; // 괄호 짝이 맞지 않으면
					break;
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			if(check == false) {
				sb.append(0);
			} else {
				sb.append(1);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
