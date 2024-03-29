import java.io.*;
import java.util.*;

public class Main_백준_3055_탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;
	static char map[][];
	static boolean v[][];
	static boolean wv[][];
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean[n][m];
		wv = new boolean[n][m];
		Queue<Integer>sx = new ArrayDeque<Integer>();
		Queue<Integer>sy = new ArrayDeque<Integer>();
		Queue<Integer>wx = new ArrayDeque<Integer>();
		Queue<Integer>wy = new ArrayDeque<Integer>();
		
		int ex = 0;
		int ey = 0;
		for(int i = 0 ; i < n ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j< m ; j++) {
				map[i][j] = s.charAt(j);
				switch (map[i][j]) {
				case 'D':
					ex = i;
					ey = j;
					break;
				case '*':
					wx.offer(i);
					wy.offer(j);
					wv[i][j] = true;
					break;
				case 'S':
					sx.offer(i);
					sy.offer(j);
					v[i][j] = true;
					break;
				}
			}
		}
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		int cnt = 0;
		while(!sx.isEmpty()) {
			cnt++;
			int wsize = wx.size();
			int psize = sx.size();
			
			while(wsize-->0) {
				int x = wx.poll();
				int y = wy.poll();
				for(int i = 0 ; i< 4 ; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx<0||nx>=n||ny<0||ny>=m||wv[nx][ny]||map[nx][ny]!='.')
						continue;
					wv[nx][ny] = true;
					wx.offer(nx);
					wy.offer(ny);
				}
			}
			while(psize-->0) {
				int x = sx.poll();
				int y = sy.poll();
				for(int i = 0 ; i< 4 ; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx<0||nx>=n||ny<0||ny>=m||wv[nx][ny]||v[nx][ny]||map[nx][ny]=='X')
						continue;
					
					if(nx==ex&&ny==ey) {
						System.out.println(cnt);
						System.exit(0);
					}
					v[nx][ny] = true;
					sx.offer(nx);
					sy.offer(ny);
				}
			}
		}
		System.out.println("KAKTUS");
	}
}
