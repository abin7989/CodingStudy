package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 하얀색: 0
 * 파란색: 1
 *
 */

// 백준 2630. 색종이 만들기
public class Baekjoon_2630 {
	static int[][] map;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 전체 종이의 한 변의 길이
		map = new int[N][N];
		
		// 색종이 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void divide(int row, int col, int size) {
		if (colorCheck(row, col, size)) {
			if (map[row][col] == 0) white++;
			else blue++;
			return;
		}
		
		int newSize = size / 2; // 사이즈 절반으로 줄이기
		
		divide(row, col + newSize, newSize); // 1사분면
		divide(row, col, newSize); // 2사분면
		divide(row + newSize, col, newSize); // 3사분면
		divide(row + newSize, col + newSize, newSize); // 4사분면	
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
