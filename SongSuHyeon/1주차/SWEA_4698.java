package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4698 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char D = st.nextToken().charAt(0);
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());

			int[] arr = new int[(B - A) + 1];
			int num = A;
			for (int i = 0; i < arr.length ; i++) {
				arr[i] = num + i;
			}

			int[] cmp = new int[B];
			cmp[0] = 1;
			cmp[1] = 1;
			for (int i = 2; i < B; i++) {
				for (int j = i + 1; j < B; j++) {
					if (j % i == 0) {
						cmp[j] = 1;
					}
				}
			}
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(cmp));
			
			System.out.println(arr[10] + " " + cmp[10]);
			 
			int cnt = 0;
			for (int i = A; i <= B-A; i++) {
				if(cmp[i] == 0) {
					String s = String.valueOf(i);
					for (int j = 0; j < s.length(); j++) {
						if(s.charAt(j) == D) {
							cnt++;
						}
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");

		} // end of test_case
		System.out.println(sb);
	} // end of main
} // end of class
