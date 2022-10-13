package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1952. 수영장
public class SWEA_1952 {
	/*
	 * 1일 이용권: 1일 이용 가능
	 * 1달 이용권: 1달 이용 가능. 매달 1일부터 시작
	 * 3달 이용권: 연속된 3달 이용 가능. 매달 1일부터 시작 (11, 12월에 사용은 가능하나 해를 넘어가는건 X)
	 * 1년 이용권: 1년 이용 가능. 매년 1월 1일 시작
	 */

	static int[] price;
	static int[] plan;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			price = new int[4];
			plan = new int[13];
			// 이용권 가격들 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			// 12개월 이용 계획 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			min = price[3];
			dfs(1, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int month, int sum) {
		if (month == 13) {
			if (sum < min)
				min = sum;
			return;
		}
		
		// 사용하지 않는 달은  가격 변화 없음
		if (plan[month] == 0) dfs(month + 1, sum);
		
		// 1일 사용권으로 채우고 dfs
		if (plan[month] > 0) dfs(month + 1, sum + plan[month] * price[0]);
		
		// 1달 사용권으로 채우기
		if (plan[month] > 0) dfs(month + 1, sum + price[1]);
		
		// 3달 사용권으로 채우기
		if (month <= 10) dfs(month + 3, sum + price[2]);
	}

}
