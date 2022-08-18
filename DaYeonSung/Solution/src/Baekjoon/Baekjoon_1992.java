package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 0: 흰 점
 * 1: 검은 점
 *
 */

// 백준 1992. 쿼드트리
public class Baekjoon_1992 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 영상의 크기
		map = new int[N][N];
		
		// 영상 정보 입력 받기
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		divide(0, 0, N);
		System.out.println(sb);
	}
	
	static void divide(int row, int col, int size) {
		if (colorCheck(row, col, size)) {
			if (map[row][col] == 0) {
				sb.append("0");
			}
			else if (map[row][col] == 1) {
				sb.append("1");
			}
			else {
				sb.append(map[row][col]);
			}
			return;
		}
		
		int newSize = size / 2; // 사이즈 절반으로 줄이기
		
		sb.append("(");
		divide(row, col, newSize); // 2사분면
		divide(row, col + newSize, newSize); // 1사분면
		divide(row + newSize, col, newSize); // 3사분면
		divide(row + newSize, col + newSize, newSize); // 4사분면
		sb.append(")");
	}
	
	static boolean colorCheck(int row, int col, int size) {
		int color = map[row][col]; // 확인해볼 컬러 초기값을 첫번째 원소를 기준으로 검사
	
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (map[i][j] != color) { // 하나라도 불일치하면
					return false; // 검사 미통과
				}
			}
		}
		// 색깔 모두 일치해서 검사 통과
		return true;
	}
}
