package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// SWEA 2805. 농작물 수확하기
public class SWEA_2805 {

	static int[][] farm;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine()); // 농장의 크기 입력 받기
			farm = new int[N][N]; // 농장 배열 정의하기
			
			// 농장 배열 입력값 받기
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				for (int c = 0; c < N; c++) {
					farm[r][c] = s.charAt(c) - '0';
				}
			}
			
			int sum = 0; // 최종 수익을 계산하기 위한 변수
			int num = N / 2;
			
			// 마름모 상단 계산
			for (int r = 0; r < num; r++) {
				for (int c = num - r; c <= num + r; c++) {
					sum += farm[r][c];
				}
			}
			// 마름모 중간 계산
			for (int c = 0; c < N; c++) {
				sum += farm[num][c];
			}
			// 마름모 하단 계산
			for (int r = num + 1; r < N; r++) {
				for (int c = r - num; c < N - r + num; c++) {
					sum += farm[r][c];
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
