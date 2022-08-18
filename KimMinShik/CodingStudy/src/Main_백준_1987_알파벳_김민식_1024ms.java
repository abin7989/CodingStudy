import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_김민식_1024ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;
	static char map[][];
	static boolean v[][];
	static boolean al[];
	static int n;
	static int m;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int max = 0;
	public static void DFS(int x,int y,int cnt) {
		max = Math.max(max,cnt);
		for(int i = 0 ; i <4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m||v[nx][ny]||al[map[nx][ny]-'A'])
				continue;
			v[nx][ny]= true;
			al[map[nx][ny]-'A'] = true;
			DFS(nx,ny,cnt+1);
			v[nx][ny] = false;
			al[map[nx][ny]-'A'] = false;
		}
	}
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char [n][m];
		v = new boolean [n][m];
		al = new boolean[26];
		String s;
		for(int i = 0 ; i < n ;i++) {
			s = br.readLine();
			for(int j = 0 ; j<m;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		al[map[0][0]-'A'] = true;
		DFS(0,0,1);
		System.out.println(max);
	}
}
