import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		//맥북 주석
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int posx = Integer.parseInt(st.nextToken());
		int posy = Integer.parseInt(st.nextToken());
		int com = Integer.parseInt(st.nextToken());
		char map[][] = new char[n][m];
		List<Character> xl = new ArrayList<Character>();
		List<Character> yl = new ArrayList<Character>();
		xl.add('0');
		xl.add('0');
		xl.add('0');
		xl.add('0');
		yl.add('0');
		yl.add('0');
		yl.add('0');
		int xlpos = 3;
		int ylpos = 1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0, index = 0; j < m; j++, index += 2) {
				map[i][j] = st.nextToken().charAt(index);
			}
		}
		//동1,서2,북3,남4
		int dx[] = {0,0,-1,1};
		int dy[] = {1,-1,0,0};
		st = new StringTokenizer(br.readLine(), " ");
		for (int q = 0, index = 0; q < com; q++,index+=2) {
			int move = st.nextToken().charAt(index);
			int nx = posx+dx[move];
			int ny = posy+dy[move];
			if(nx<0||nx>=n||ny<0||ny>=m) continue;
			int nxl = bo(xlpos+dx[move],4);
			int nyl = bo( ylpos+dy[move],3);
			switch (move) {
			case 3:
			case 4:
				xl.set(nxl,map[nx][ny]);
				if(nxl==1)
					yl.set(1, map[nx][ny]);
				break;
			case 1:
			case 2:
				yl.set(nyl,map[nx][ny]);
				if(nyl==1)
					xl.set(1, map[nx][ny]);
				break;
			}
			
		}
	}
	static int bo(int n,int b) {
		if(n<0) {
			return b-n;
		}
		else if(n>=b) {
			return n-b;
		}
		return n;
	}
}
