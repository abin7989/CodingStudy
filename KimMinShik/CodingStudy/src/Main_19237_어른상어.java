import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_19237_어른상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dx[] = { 0, -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 0, -1, 1 };
	static int n;
	static int m;
	static int k;
	static Point pos[];
	static Point sm[][];
	static int smMap[][];
	static int smSize[][];
	static int nowMove[];
	static int map[][];
	static int nextMove[][][];
	static int smcnt = 0;
	static boolean[] die;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		pos = new Point[m + 1];
		die = new boolean[m+1];
		sm = new Point[m + 1][k];
		smMap = new int[n][n];
		smSize = new int[n][n];
		nowMove = new int[m + 1];
		map = new int[n][n];
		nextMove = new int[m + 1][5][4];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				smMap[i][j] = Integer.parseInt(st.nextToken());
				if (smMap[i][j] != 0) {
					smSize[i][j]++;
					sm[smMap[i][j]][0] = new Point(i,j);
					pos[smMap[i][j]] = new Point(i, j);
				}
			}
		} // 맵 생성 종료

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= m; i++) {
			nowMove[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				nextMove[i][j][0] = Integer.parseInt(st.nextToken());
				nextMove[i][j][1] = Integer.parseInt(st.nextToken());
				nextMove[i][j][2] = Integer.parseInt(st.nextToken());
				nextMove[i][j][3] = Integer.parseInt(st.nextToken());
			}
		} // 우선순위 설정 종료
		int cnt = 1;
		boolean chDie = true;
		for (; cnt <= 1000; cnt++) {
			makeMove();
			makeSm();
			chDie = true;
			for(int j = 2 ; j <=m;j++) 
				if(!die[j])
					chDie = false;
			if(chDie)
				break;
		}
		if(chDie)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}
	static void makeSm() {
		smcnt = (smcnt + 1) % k;
		for (int i = 1; i <= m; i++) {
			Point p = pos[i];
			
			if(smMap[p.x][p.y]!=0&&smMap[p.x][p.y]!=i) 
				die[i] = true;
			
			if(die[i]) {
				if(sm[i][smcnt] != null) {
					if(smSize[sm[i][smcnt].x][sm[i][smcnt].y]==1) {
						smMap[sm[i][smcnt].x][sm[i][smcnt].y] = 0;
					}
					smSize[sm[i][smcnt].x][sm[i][smcnt].y]--;
					sm[i][smcnt] = null;
				}
				continue;
			}
			if (sm[i][smcnt] == null)
				sm[i][smcnt] = new Point(p.x, p.y);
			else {
				if(smSize[sm[i][smcnt].x][sm[i][smcnt].y]==1) {
					smMap[sm[i][smcnt].x][sm[i][smcnt].y] = 0;
				}
				smSize[sm[i][smcnt].x][sm[i][smcnt].y]--;
				
				sm[i][smcnt].x = p.x;
				sm[i][smcnt].y = p.y;
			}
			smSize[p.x][p.y]++;
			smMap[p.x][p.y] = i;
		}
	}

	static void makeMove() {
		for (int i = 1; i <= m; i++) {
			Point p = pos[i];
			int x = p.x;
			int y = p.y;
			int tM = nowMove[i];
			int nowM = nextMove[i][tM][0];
			boolean pass = false;
			for (int j = 1; j <= 4; j++) {
				int nx = x + dx[nowM];
				int ny = y + dy[nowM];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || (smMap[nx][ny] != 0)) {
					if (j != 4)
						nowM = nextMove[i][tM][j];
					continue;
				}
				pass = true;
				pos[i].x= nx;
				pos[i].y= ny;
				nowMove[i] = nowM;
			}
			if(!pass) {
				nowM = nextMove[i][tM][0];
				for (int j = 1; j <= 4; j++) {
					int nx = x + dx[nowM];
					int ny = y + dy[nowM];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n ||smMap[nx][ny] != i) {
						if (j != 4)
							nowM = nextMove[i][tM][j];
						continue;
					}
					pass = true;
					pos[i].x= nx;
					pos[i].y= ny;
					nowMove[i] = nowM;
				}
			}
		}
	}

}
