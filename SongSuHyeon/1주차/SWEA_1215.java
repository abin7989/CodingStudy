import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1215 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.valueOf(br.readLine());
			char[][] arr = new char[10][10];
			for (int i = 1; i <= 8; i++) {
				String s = br.readLine();
				for (int j = 1; j <= 8; j++) {
					arr[i][j] = s.charAt(j - 1);
				}
			}

			// 가로 검색
			int last = N, cnt = 0;
			for (int i = 1; i <= 8; i++) {
				for (int j = 1; j <= 8 - N + 1; j++) {
					boolean check = true; // 회문이라고 가정
					for (int k = 0; k < N / 2; k++) {
						if (arr[i][j + k] != arr[i][N - 1 + j - k]) {
							check = false;
						}
					}

					if (check) {
						cnt++;
					}
				}
			}

			// 세로 검색
			for (int i = 1; i <= 8; i++) {
				for (int j = 1; j <= 8 - N + 1; j++) {
					boolean check = true; // 회문이라고 가정
					for (int k = 0; k < N / 2; k++) {
						if (arr[j + k][i] != arr[N - 1 + j - k][i]) {
							check = false;
						}
					}

					if (check) {
						cnt++;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
