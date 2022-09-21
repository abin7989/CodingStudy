package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1018. 체스판 다시 칠하기
public class Baekjoon_1018 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		
		for (int r = 0; r < N; r++) {
			board[r] = br.readLine().toCharArray();
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int r = 0; r <= N - 8; r++) {
			for (int c = 0; c <= M - 8; c++) {
				int min_w = examineBoardW(r, c, board);
				int min_b = examineBoardB(r, c, board);
				
				if (min_w < min) {
					min = min_w;
				}
				if (min_b < min) {
					min = min_b;
				}
			}
		}
		
		System.out.println(min);

		
	}
	
	// board[row][col]이 W일 때
	private static int examineBoardW(int row, int col, char[][] board) {
		int cnt = 0;
		
		for (int r = row; r < row + 8; r++) {
			for (int c = col; c < col + 8; c++) {
				if ((r + c) % 2 == 0) {
					if (board[r][c] != 'W') {
						cnt++;
					}
				} else {
					if (board[r][c] != 'B') {
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}
		

	// board[row][col]이 B일 때
	private static int examineBoardB(int row, int col, char[][] board) {
		int cnt = 0;
		
		for (int r = row; r < row + 8; r++) {
			for (int c = col; c < col + 8; c++) {
				if ((r + c) % 2 == 0) {
					if (board[r][c] != 'B') {
						cnt++;
					}
				} else {
					if (board[r][c] != 'W') {
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}
	
}
