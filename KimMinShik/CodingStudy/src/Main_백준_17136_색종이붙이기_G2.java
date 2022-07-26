import java.io.*;
import java.util.*;

public class Main_백준_17136_색종이붙이기_G2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st = null;
	static boolean map[][] = new boolean[10][10];
	static boolean v[][] = new boolean[10][10];
	static int c[] = { 0, 5, 5, 5, 5, 5 };
	static int min = Integer.MAX_VALUE;

	static void DFS(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			min = Math.min(min, cnt);
			return;
		}
		if (min <= cnt) {
			return;
		}
		if (y > 9) {
			DFS(x + 1, 0, cnt);
			return;
		}
		if (map[x][y]) {

			for (int t = 5; t > 0; t--) {
				if (c[t] < 1)
					continue;
				if(x+t>10||y+t>10)
					continue;
				boolean pass = true;
				nf: for (int p = x; p < x + t; p++) {
					for (int q = y; q < y + t; q++) {
						if (!map[p][q]) {
							pass = false;
							break nf;
						}
					}
				}
				if (pass) {
					for (int p = x; p < x + t; p++) {
						for (int q = y; q < y + t; q++) {
							map[p][q] = !map[p][q];
						}
					}
					c[t]--;
					DFS(x, y + 1, cnt + 1);
					for (int p = x; p < x + t; p++) {
						for (int q = y; q < y + t; q++) {
							map[p][q] = !map[p][q];
						}
					}
					c[t]++;
				}
			}
		}else {
			DFS(x,y+1,cnt);
		}
	}

	public static void main(String[] args) throws IOException {

		String s = null;
		for (int i = 0; i < 10; i++) {
			s = br.readLine();
			for (int j = 0, index = 0; j < 10; j++, index += 2) {
				if (s.charAt(index) == '1')
					map[i][j] = true;
			}
		}
		DFS(0,0,0);
		if(min!=Integer.MAX_VALUE)
		System.out.println(min);
		else
			System.out.println(-1);
	}
}
