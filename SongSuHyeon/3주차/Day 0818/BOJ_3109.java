package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3109 {

	static int R, C, cnt;
	static int[] dr = { -1, 0, 1 }; // 오른쪽만 검색함으로 dc = 1
	static char[][] arr;
	static boolean check;
	static ArrayList<Integer> graph[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			check = false;
			DFS(i, 0);
		}

		System.out.println(cnt);

	} // end of main

	private static void DFS(int startX, int startY) {

		if (startY == C - 1) {
			check = true;
			cnt++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nr = startX + dr[i];
			int nc = startY + 1;

			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if (arr[nr][nc] == '.') {
					arr[startX][startY] = '-';
					DFS(nr, nc);
					if (check)
						return;
				}

			}

		}

	} // end of DFS

} // end of class
