package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 2068. 최대수 구하기
public class SWEA_2068 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for (int num: arr) {
				if (num > max) max = num;
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
						
		}
		System.out.print(sb);
	}

}
