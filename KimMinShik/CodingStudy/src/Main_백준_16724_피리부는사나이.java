import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_백준_16724_피리부는사나이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);
	static Node al[][];
	static char map[][];
	static boolean v[][];
	static int n;
	static int m;

	static Point move(int x, int y) {
		switch (map[x][y]) {
		case 'U':
			return new Point(x - 1, y);
		case 'D':
			return new Point(x + 1, y);
		case 'L':
			return new Point(x, y - 1);
		case 'R':
			return new Point(x, y + 1);
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m];
		al = new Node[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				al[i][j] = new Node();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j])
					continue;
				v[i][j] = true;
				dfs(i, j);
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (al[i][j].p == al[i][j])
					cnt++;
		System.out.println(cnt);
		return;
	}

	static void dfs(int x, int y) {
		al[x][y].p = al[x][y];
		Point p = move(x, y);
		int nx = p.x;
		int ny = p.y;
		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			return;
		if (v[nx][ny]) {
			u(x, y, nx, ny);
			return;
		}
		v[nx][ny] = true;
		al[x][y].p = al[nx][ny];
		dfs(nx, ny);
	}

	static void u(int x, int y, int nx, int ny) {
		int tx = nx;
		int ty = ny;
		Node temp = al[tx][ty].p;
		while (temp.p != temp) {
			temp = temp.p;
		}
		al[x][y].p = temp;

	}

	static class Node {
		Node p;
	}
}
