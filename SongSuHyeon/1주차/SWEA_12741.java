package day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12741 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int[] arr = new int[4];
			int[] light = new int[100];
			for (int i = 0; i < 4; i++) {
				arr[i] = Integer.valueOf(st.nextToken());
			}

			for (int i = arr[0]; i < arr[1]; i++) {
				light[i]++;
			}
			for (int i = arr[2]; i < arr[3]; i++) {
				light[i]++;
			}

			int time = 0;
			for (int i = 0; i < light.length; i++) {
				if (light[i] == 2) {
					time++;
				}
			}
			System.out.println("#" + test_case + " " + time);
			
		} // end of test_case

	} // end of main
} // end of class
