package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11660. 구간 합 구하기 5
public class Baekjoon_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		int[][] arr = new int[N+1][N+1]; // 왼쪽, 위쪽으로 공백 만들어주기
		
//		행 별로 누적합 배열 구하기
		for (int i = 1; i <= N; i++) {
			int pre = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = pre + Integer.parseInt(st.nextToken());
				pre = arr[i][j];
			}
			
		}
		
		for (int i = 0; i < M; i++) { // M줄에 걸쳐
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
//			사각형 모양대로 행 별로 sum에 더하기
			for (int j = x1; j <= x2; j++) {
				sum += (arr[j][y2] - arr[j][y1 - 1]);
			}
			sb.append(sum).append("\n");					
		}
		System.out.println(sb);
	}

}