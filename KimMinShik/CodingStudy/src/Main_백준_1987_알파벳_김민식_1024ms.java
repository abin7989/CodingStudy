import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_김민식_1024ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;
	static int map[][];
	static int n;
	static int m;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int max = 0;
	static boolean pass = false;
	public static void DFS(int x,int y,int cnt,int v) {
		max = Math.max(max,cnt);
		if(cnt==26) {
			pass = true;
			return;
		}
		for(int i = 0 ; i <4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m||(v&1<<map[nx][ny])!=0)
				continue;
			DFS(nx,ny,cnt+1,v|1<<map[nx][ny]);
			if(pass) return;
		}
	}
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		String s;
		for(int i = 0 ; i < n ;i++) {
			s = br.readLine();
			for(int j = 0 ; j<m;j++) {
				map[i][j] = s.charAt(j)-'A';
			}
		}
		DFS(0,0,1,1<<map[0][0]);
		System.out.println(max);
	}
}
