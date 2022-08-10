package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935 {
	static int N, M, R, totalCnt;
	static int[][] arr;
	static int[][] tmp;
	static int[][] cmd;
	static int[][] part1;
	static int[][] part2;
	static int[][] part3;
	static int[][] part4;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.valueOf(st.nextToken()); // N * M 배열의 크기
		M = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken()); // 회전 연산의 개수

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}

		int[] cmd = new int[R];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int t = 0; t < R; t++) {
			cmd[t] = Integer.valueOf(st2.nextToken());
		}
		
		for (int t = 0; t < R; t++) {
			switch (cmd[t]) {
			case 1:
				// 1번 : 상하 반전
				tmp = new int[N][M];
				for (int i = 0, end = N-1; i < N / 2; i++, end--) {
					tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
					arr[i] = Arrays.copyOf(arr[end], arr[i].length);
					arr[end] = tmp[i];
				}
				break;
			case 2:
				// 2번 : 좌우 반전
				tmp = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0, end = M-1; j < M / 2; j++, end--) {
						tmp[i][j] = arr[i][j];
						arr[i][j] = arr[i][end];
						arr[i][end] = tmp[i][j];
					}
				}
				break;

			case 3:
				// 3번 : 오른쪽으로 90도 회전
				tmp = new int[M][N];
				int C = N - 1;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						tmp[j][C] = arr[i][j];
					}
					C--;
				}
				int temp1 = N;
				N = M;
				M = temp1;

				arr = tmp;
				break;

			case 4:
				// 4번 : 왼쪽으로 90도 회전
				tmp = new int[M][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						tmp[M - j - 1][i] = arr[i][j];
					}
				}
				int temp2 = N;
				N = M;
				M = temp2;

				arr = tmp;
				break;

			case 5:
				part1 = new int[N / 2][M / 2];
				part2 = new int[N / 2][M / 2];
				part3 = new int[N / 2][M / 2];
				part4 = new int[N / 2][M / 2];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (i < N / 2 && j < M / 2) {
							part1[i][j] = arr[i][j];
						} else if (i < N / 2 && j >= M / 2) {
							part2[i][j - (M / 2)] = arr[i][j];
						} else if (i >= N / 2 && j < M / 2) {
							part4[i - (N / 2)][j] = arr[i][j];
						} else if (i >= N / 2 && j >= M / 2) {
							part3[i - (N / 2)][j - (M / 2)] = arr[i][j];
						}
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (i < N / 2 && j < M / 2) {
							arr[i][j] = part4[i][j];
						} else if (i < N / 2 && j >= M / 2) {
							arr[i][j] = part1[i][j - (M / 2)];
						} else if (i >= N / 2 && j < M / 2) {
							arr[i][j] = part3[i - (N / 2)][j];
						} else if (i >= N / 2 && j >= M / 2) {
							arr[i][j] = part2[i - (N / 2)][j - (M / 2)];
						}
					}
				}

				break;

			case 6:
				part1 = new int[N / 2][M / 2];
				part2 = new int[N / 2][M / 2];
				part3 = new int[N / 2][M / 2];
				part4 = new int[N / 2][M / 2];
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (i < N / 2 && j < M / 2) {
							part1[i][j] = arr[i][j];
						} else if (i < N / 2 && j >= M / 2) {
							part2[i][j - (M / 2)] = arr[i][j];
						} else if (i >= N / 2 && j < M / 2) {
							part4[i - (N / 2)][j] = arr[i][j];
						} else if (i >= N / 2 && j >= M / 2) {
							part3[i - (N / 2)][j - (M / 2)] = arr[i][j];
						}
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (i < N / 2 && j < M / 2) {
							arr[i][j] = part2[i][j];
						} else if (i < N / 2 && j >= M / 2) {
							arr[i][j] = part3[i][j - (M / 2)];
						} else if (i >= N / 2 && j < M / 2) {
							arr[i][j] = part1[i - (N / 2)][j];
						} else if (i >= N / 2 && j >= M / 2) {
							arr[i][j] = part4[i - (N / 2)][j - (M / 2)];
						}
					}
				}
				
				break;
			} // end of switch

		}  // end of R
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	} // end of main

} // end of class
