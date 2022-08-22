import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {

	static int L, C;
	static char[] arr, text;
	static boolean[] isSelected;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			String s = st.nextToken();
			arr[i] = s.charAt(0);
		}

		text = new char[L];
		isSelected = new boolean[C];
		Arrays.sort(arr);

		comb(0, 0);
		System.out.println(sb);

	}

	private static void comb(int cnt, int start) {

		if (cnt == L) {

			boolean check = false;
			for (char c : text) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					check = true;
					break;
				}
			}
			
			int check2 = 0;
			for (char c : text) {
				if(check2 >= 2) {
					break;
				}
				
				if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
					check2++;
				}
			}
			
			
			boolean check3 = false;
			if(check) {
				for (int i = L-1; i > 0; i--) {
					if (arr[i] <= arr[i - 1]) {
						check3 = true;
						break;
					}
				}
			}

			
			if(check && check2 >= 2 && !check3) {
				for (char c : text) {
					sb.append(c);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {

			text[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}

}
