package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1932. 정수 삼각형
public class Baekjoon_1932 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 삼각형 각 라인 양 끝 수들 먼저 구하기
		for (int i = 1; i < n; i++) {
			map[i][0] += map[i-1][0];
			map[i][i] += map[i-1][i-1];
		}
		
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				map[i][j] += Math.max(map[i-1][j-1], map[i-1][j]);
			}
		}
		
		Arrays.sort(map[n-1]);
		
		System.out.println(map[n-1][n-1]);

	}

}
