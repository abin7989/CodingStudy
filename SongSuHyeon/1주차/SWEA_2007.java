import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			for (int i = 1; i <= s.length(); i++) {
				String b = s.substring(0, i);
				String c = s.substring(i, i+ i);
				if(b.equals(c)) {
					System.out.printf("#%d %d\n", test_case, b.length());
					break;
				}
			}	
		}
	}
}
