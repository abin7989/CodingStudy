package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1220. Magnetic
public class SWEA_1220 {
	/**
	 * 
	 * 0: 빈 칸
	 * 1: N극 성질을 가지는 자성체
	 * 2: S극 성질을 가지는 자성체
	 * 테이블의 윗부분: N극
	 * 테이블의 아랫부분: S극
	 * 
	 */
	
	static int N;
	static int[][] arr;
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			cnt = 0;
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 정사각형 테이블의 한 변의 길이 (이 값은 항상 100이다)
			arr = new int[100][100];
//			테이블 초기 모습 입력 받기
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 왼쪽부터 차례대로 검사
			for (int c = 0; c < N; c++) {
				int num = 0; // 자성체가 존재할 때 (flag가 true일 때) 그 자성체가 N극인지 S극인지 확인할 변수
				for (int r = 0; r < N; r++) {
					if (arr[r][c] == 1) {
						search(r, c);
						break;
					}
				}			
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void search(int row, int col) { // 그 행의 맨 위가 N극일 경우
		boolean topRed = false;
		for (int r = row; r < N; r++) {
			if (arr[r][col] == 1) {
				topRed = true;
			}
			if (topRed && arr[r][col] == 2) {
				cnt++;
				topRed = false;
			}
		}
	}

}
