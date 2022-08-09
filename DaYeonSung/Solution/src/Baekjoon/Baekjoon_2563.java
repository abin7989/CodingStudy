package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2563. 색종이

/**
 * 
 * 가로, 세로 100인 정사각형 흰색 도화지
 * 가로, 세로 10인 정사각형 검은색 색종이
 * 검은색 색종이를 도화지와 평행하게 한 장 또는 여러 장을 붙인다
 * 색종이가 붙은 검은 영역의 넓이 구하기
 *
 */
public class Baekjoon_2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[100][100]; // 흰색 도화지
		int cnt = 0; // 검은 영역의 넓이 변수
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken()); // 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
			int bottom = Integer.parseInt(st.nextToken()); // 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
			for (int r = bottom; r < bottom + 10; r++) {
				for (int c = left; c < left + 10; c++) {
					if (map[r][c] == 1) continue; // 이미 색종이를 붙인 구역이라면 continue
					else { // 아니라면
						map[r][c] = 1; // 색종이 붙이고
						cnt++; // 그 영역 카운트
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
