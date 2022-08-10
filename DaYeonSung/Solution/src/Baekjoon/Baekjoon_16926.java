package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 16926. 배열 돌리기 1
public class Baekjoon_16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // row
		int M = Integer.parseInt(st.nextToken()); // col
		int R = Integer.parseInt(st.nextToken()); // 회전의 수

		int[][]A  = new int[N][M];
		
//		배열 입력 받기
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 1;
		int tmp1 = 0;
		int tmp2 = 0;
		int rotate = Math.min(N, M) / 2; // 각각 두 수 중 더 작은 수를 2로 나눈 횟수만큼 돌려야 함
		while(num++ <= R) {
			for (int i = 0; i < rotate; i++) {
				tmp1 = A[i][i]; // 좌측 맨 상단 idx 일시 저장
				tmp2 = A[i][i+1]; // 좌측 맨 상단 우측 idx 일시 저장
				for (int c = 0; c < M; c++) {
					if (c > i && c < M - i - 1) { // 상단 돌리기
						A[i][c] = A[i][c+1];
					}
				}
				for (int r = 0; r < N; r++) {
					if (r >= i && r < N - i - 1) { // 우측 돌리기
						A[r][M - i - 1] = A[r+1][M - i - 1];
					}
				}
				for (int c = M- 1; c >= 0; c--) {
					if (c < M - i && c > i) { // 하단 돌리기
						A[N - i - 1][c] = A[N - i - 1][c-1];
					}
				}
				for (int r = N - 1; r >= 0; r--) {
					if (r > i && r < N - i) { // 좌측 돌리기
						A[r][i] = A[r-1][i];
					}
				}
				A[i+1][i] = tmp1;
				A[i][i] = tmp2;
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(A[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
