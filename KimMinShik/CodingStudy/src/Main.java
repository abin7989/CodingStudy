
import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);
	static int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int dy[] = { -2, -1, 1, 2, -2, -1, 1, 2 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0 ;
		int nx = 0; 
		int ny = 0;
		int cnt = 0;
		int size = 0;
		mk:for (int test_case = 0; test_case < T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			boolean v[][] = new boolean[n][n];
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			Queue<Point> q = new ArrayDeque<Point>();
			q.add(new Point(sx,sy));
			v[sx][sy] = true;
			cnt = 0;
			while(!q.isEmpty()) {
				size = q.size();
				while(size-->0) {
					x = q.peek().x;
					y = q.poll().y;
					if(x==ex&&y==ey) {
						System.out.println(cnt);
						continue mk;
					}
						
					for(int i = 0 ; i<8;i++) {
						nx = x+dx[i];
						ny = y+dy[i];
						if(nx<0||nx>=n||ny<0||ny>=n||v[nx][ny])
							continue;
						v[nx][ny]= true;
						q.add(new Point(nx,ny));
					}
				}
				cnt++;
			}
		}
	}
}
