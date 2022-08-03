package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4047 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int[] S = new int[14];
			int[] D = new int[14];
			int[] H = new int[14];
			int[] C = new int[14];
			
			boolean flag = false;
			String s = br.readLine();
			for (int i = 0; i < s.length(); i = i + 3) {
				String tmp = "";
				tmp += s.charAt(i + 1);
				tmp += s.charAt(i + 2);
				int num = Integer.valueOf(tmp);
				if (s.charAt(i) == 'S') {
					if (S[num] == 0) {
						S[num]++;
					}
					else {
						flag = true;
						break;
					}
				} else if (s.charAt(i) == 'D') {
					if (D[num] == 0) {
						D[num]++;
					}
					else {
						flag = true;
						break;
					}
				} else if (s.charAt(i) == 'H') {
					if (H[num] == 0) {
						H[num]++;
					}
					else {
						flag = true;
						break;
					}
				} else if (s.charAt(i) == 'C') {
					if (C[num] == 0) {
						C[num]++;
					}
					else {
						flag = true;
						break;
					}
				}
			}

			int s_sum = 13, h_sum = 13, d_sum = 13, c_sum = 13;
			for (int j = 1; j < 14; j++) {
				s_sum -= S[j];
				h_sum -= H[j];
				d_sum -= D[j];
				c_sum -= C[j];
			}
			
			if(flag == false) {
				sb.append(s_sum).append(" ").append(d_sum).append(" ").append(h_sum).append(" ").append(c_sum).append("\n");
			}
			else {
				sb.append("ERROR").append("\n");
			}
		} // end of test_case
		System.out.println(sb);
	} // end of main
} // end of class
