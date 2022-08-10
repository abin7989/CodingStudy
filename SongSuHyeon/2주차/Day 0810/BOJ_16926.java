package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	static int N, M, R, totalCnt;
	static int[][] arr;
	static int[][] tmp;
	static int[][] cmd;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.valueOf(st.nextToken()); // N * M 배열의 크기
		M = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken()); // 회전 연산의 개수

		arr = new int[N + 2][M + 2];
		tmp = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.valueOf(st2.nextToken());
			}
		}

		for (int t = 0; t < R; t++) {
			int top = 1, left = 1, bottom = N, right = M;

			for (int i = 0; i < N / 2; i++) {

				int temp1 = arr[bottom][left];
				for (int row = bottom - 1; row >= top; row--) { // v
					arr[row + 1][left] = arr[row][left];
				}
				left++;

				int temp2 = arr[bottom][right];
				for (int col = right - 1; col >= left; col--) { // >
					arr[bottom][col + 1] = arr[bottom][col];
				}
				arr[bottom][left] = temp1;
				bottom--;

				int temp3 = arr[top][right];
				for (int row = top + 1; row <= bottom; row++) { // ^
					arr[row - 1][right] = arr[row][right];
				}
				arr[bottom][right] = temp2;
				right--;

				for (int col = left; col <= right; col++) { // <
					arr[top][col - 1] = arr[top][col];
				}
				arr[top][right] = temp3;
				top++;

			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	} // end of main

} // end of class
