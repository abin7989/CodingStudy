package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4789 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			int[] arr = new int[s.length() + 1];
			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.valueOf(s.charAt(i - 1) - 48);
			}

			int stand = 0, cnt = 0;
			for (int i = 1; i < arr.length; i++) {
				stand += arr[i];
				if (stand < i) {
					cnt += i - stand;
					stand += i - stand;
				}

			}
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
