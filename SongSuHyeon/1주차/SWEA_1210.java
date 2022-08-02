package day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아래서 부터 탐색
 * 1. 제일 아래줄에서 2 탐색
 * 2. 위로 이동
 * 	2-1 좌우 방향 통로를 만나면 방향 전환
 * 3. top에 도착하면 출력
 */
public class SWEA_1210 {
	static int[][] map = new int[102][102];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.valueOf(br.readLine());
			int des_i = 0, des_j = 0;
			for (int i = 1; i < map.length - 1; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for (int j = 1; j < map.length - 1; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
					if (map[i][j] == 2) {
						des_i = i;
						des_j = j;
					}
				}
			}
			while (des_i > 1) {
				if (map[des_i][des_j - 1] == 1) {
					map[des_i][des_j] = 0;
					des_j--;

				} else if (map[des_i][des_j + 1] == 1) {
					map[des_i][des_j] = 0;
					des_j++;

				} else {
					des_i--;
				}
			}
			sb.append("#").append(test_case).append(" ").append(des_j - 1).append("\n");
		} // end of test_case
		System.out.println(sb);
	} // end of main
} // end of class
