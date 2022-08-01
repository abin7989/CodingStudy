package com.ssafy.study.Test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Test5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Test5.txt"));
		char map[][] = new char[21][21];
		for (int i = 1; i < 20; i++) {
			String st = br.readLine();
			for (int j = 1, index = 0; j < 20; j++, index += 2) {
				map[i][j] = st.charAt(index);
			}
		}
		char win = '0';
		int posx = -1;
		int posy = -1;
		int dx[] = { -1, 0, 1, 1 };
		int dy[] = { 1, 1, 1, 0 };
		EXIT: for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (map[i][j] == '0')
					continue;

				for (int k = 0; k < 4; k++) {
					int cnt = 1;
					int x = i;
					int y = j;
					if (map[x - dx[k]][y - dy[k]] == map[i][j])
						continue;

					while (true) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (map[nx][ny] != map[i][j]) {
							break;
						}
						x = nx;
						y = ny;
						cnt++;
					} // while end

					if (cnt == 5) {
						posx = i;
						posy = j;
						win = map[i][j];
						break EXIT;
					}
				} // k for end
			} // j for end
		} // for end
		if (win == '0')
			System.out.printf("0");
		else
			System.out.printf("%c\n%d %d", win, posx, posy);
	}

}