package day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208_2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int[] cnt = new int[101];
			int max = 0;
			int min = 100;
			int sum = 0;
			for (int i = 0; i < 100; i++) {

				int x = Integer.parseInt(st.nextToken());
				cnt[x]++;
				if (max < x)
					max = x;
				if (min > x)
					min = x;
				sum += x;

			}
			int target = sum % 100 == 0 ? 0 : 1;

			for (int i = 0; i < N && max - min > target; i++) {

				cnt[max]--;
				cnt[max - 1]++;
				cnt[min]--;
				cnt[min + 1]++;
				if (cnt[max] == 0)
					max--;
				if (cnt[min] == 0)
					min++;

			}

			sb.append("#").append(testCase).append(" ").append(max - min).append("\n");

		}

		System.out.print(sb);

	}
} // end of class
