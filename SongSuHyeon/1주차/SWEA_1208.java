package day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int dump_cnt = Integer.valueOf(br.readLine());
			int[] box = new int[100];
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.valueOf(st.nextToken());
			}

			for (int i = 1; i <= dump_cnt; i++) {
				Arrays.sort(box);
				if (box[box.length - 1] - box[0] == 0 || box[box.length - 1] - box[0] == 1) {
					break;
				} else {
					box[0]++;
					box[box.length - 1]--;
				}
			}
			
			Arrays.sort(box);
			System.out.println("#" + test_case +" " +(box[box.length-1]-box[0]));

		}
	}
}
