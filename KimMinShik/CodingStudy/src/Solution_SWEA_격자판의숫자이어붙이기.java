import java.io.*;
import java.util.*;

public class Solution_SWEA_격자판의숫자이어붙이기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static int map[][] = new int[4][4];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static Set<Integer> set;
	public static void DFS(int x,int y,int cnt,int num) {
		if(cnt==6) {
			set.add(num);
			return;
		}
		for(int i = 0 ; i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=4||ny>=4)
				continue;
			DFS(nx,ny,cnt+1,num*10+map[nx][ny]);
		}
	}
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < 4; j++, index += 2) {
					map[i][j] = s.charAt(index) - '0';
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0, index = 0; j < 4; j++, index += 2) {
					DFS(i,j,0,map[i][j]);
				}
			}
			sb.append("#").append(test).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}
}
