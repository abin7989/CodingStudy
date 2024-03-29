import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_백준_5427_불 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case<T;test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			Queue<Point> pq = new ArrayDeque<Point>();
			Queue<Point> fq = new ArrayDeque<Point>();
			char map[][] = new char[n + 2][m + 2];
			boolean v[][] = new boolean[n + 2][m + 2];
			boolean fv[][] = new boolean[n + 2][m + 2];
			for (int i = 1; i <= n; i++) {
				String s = br.readLine();
				for (int j = 1,index=0; j <= m; j++,index++) {
					map[i][j] = s.charAt(index);
					if (map[i][j] == '@') {
						pq.add(new Point(i, j));
						v[i][j] = true;
					} else if (map[i][j] == '*') {
						fq.add(new Point(i, j));
						v[i][j] = true;
					}
				}
			}
			boolean pass = false;
			Point p;
			int psize;
			int fsize;
			int x;
			int y;
			int nx;
			int ny;
			int i = 0;
			int cnt = 0;
			bw:while (!pq.isEmpty()) {
				psize = pq.size();
				fsize = fq.size();
				
				while(fsize-->0) {
					p = fq.poll();
					x = p.x;
					y = p.y;
					for (i = 0; i < 4; i++) {
						nx = x + dx[i];
						ny = y + dy[i];
						if (fv[nx][ny]||map[nx][ny]=='#'||map[nx][ny]==0)
							continue;
						fv[nx][ny] = true;
						fq.add(new Point(nx, ny));
					}
				}
				while (psize-- > 0) {
					p = pq.poll();
					x = p.x;
					y = p.y;
					if (map[x][y] == 0) {
						pass = true;
						break bw;
					}
					for (i = 0; i < 4; i++) {
						nx = x + dx[i];
						ny = y + dy[i];
						if (v[nx][ny]||fv[nx][ny]||map[nx][ny]=='#')
							continue;
						v[nx][ny] = true;
						pq.add(new Point(nx, ny));
					}
				}
				
				cnt++;
			}
			if(pass)
				sb.append(cnt).append("\n");
			else
				sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb);
	}
}
