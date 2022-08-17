import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int score = 1, sum = 0;
			boolean flag = false;

			for (int j = 0; j < s.length(); j++) {
				if (flag == false) {
					if (s.charAt(j) == 'O') {
						sum += score;
						flag = true;
					} else {
						score = 1;
						flag = false;
					}
				} else {
					if (s.charAt(j) == 'O') {
						score++;
						sum += score;
					} else {
						score = 1;
						flag = false;
					}
				}

			}

			System.out.println(sum);
		}

	}

}
