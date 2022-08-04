package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SWEA 1984. 중간 평균값 구하기
public class SWEA_1984 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		
		for (int tc = 1; tc <= T; tc++) {
			int[] nums = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums); // 배열 오름차순 정렬
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				sum += nums[i];
			}
			sb.append("#").append(tc).append(" ").append(Math.round(sum / 8.0)).append("\n");
		}
		System.out.println(sb);
	}

}
