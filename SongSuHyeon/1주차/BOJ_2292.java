import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());

		int start = 1, end = 1, cnt = 1, num = 6;
		while (true) {
			if (start <= N && N <= end) {
				break;
			} else {
				start = end + 1;
				end += num;
				System.out.println(start + " " + end);
				num +=6;
			}
			cnt++;
		}
		System.out.println(cnt);
	} // end of main
} // end of class
