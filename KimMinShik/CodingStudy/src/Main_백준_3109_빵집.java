import java.io.*;
import java.util.*;

public class Main_백준_3109_빵집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st = null;
	static char map[][];
	static boolean v[][];
	static boolean pass = false;
	static int dx[] = {-1,0,1};
	static int dy[] = {1,1,1};
	static int n ;
	static int m ;
	static int cnt;
	static void DFS(int x,int y) {
		if(y==m-1) {
			pass = true;
			cnt++;
			return;
		}
		for(int i = 0 ; i<3;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>=n||map[nx][ny]=='x'||v[nx][ny])
				continue;
			v[nx][ny] = true;
			DFS(nx,ny);
			if(pass)
				return;
		}
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		v = new boolean [n][m];
		String s ="";
		for(int i = 0 ; i <n;i++) {
			s = br.readLine();
			for(int j = 0 ; j< m ;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		cnt = 0;
		for(int i = 0 ; i<n;i++) {
			pass = false;
			DFS(i,0);
		}
		System.out.println(cnt);
	}
}
