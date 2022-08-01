package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 일 수
			int[] price = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = price[N - 1];
			long profit = 0; // int 범위 벗어날 수 있어서 long으로 선언하는 것이 중요
			
			for (int i = N - 1; i >= 0; i--) { // 배열 거꾸로 돌면서 매매가 최댓값 구하기 (최댓값과 같은 날이 뒤에 있을 수 있으니까)
				if (price[i] > max) {
					max = price[i];
				} else {
					profit += (max - price[i]);
				}
				
			}
			
			System.out.printf("#%d %d\n", tc, profit);
		}
	}

}
