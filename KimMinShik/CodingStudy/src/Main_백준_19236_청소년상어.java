import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_백준_19236_청소년상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(100);
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static boolean fdie[] = new boolean[17];
	static Point fpos[] = new Point[17];
	static int fmove[] = new int[17];
	static int px = 0;
	static int py = 0;
	static int pmove = 0;
	static int map[][];
	static int max;

	public static void main(String[] args) throws IOException {
		map = new int[4][4];
		int move[][] = new int[4][4];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				fpos[map[i][j]] = new Point(i, j);

				fmove[map[i][j]] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		int sum = map[0][0];
		fdie[sum] = true;
		pmove = fmove[sum];
		eat(0, 0, pmove, sum);
		System.out.println(max);

	}

	static void eat(int x, int y, int pos, int sum) {
		int cnt = 0;
		int tmap[][] = new int[4][4];
		Point[] tpos = new Point[17]; 
		for(int i =1 ; i < 17;i++) {
			tpos[i] =  new Point(fpos[i].x,fpos[i].y);
		}
		int[] tmove = Arrays.copyOf(fmove, 17);
		for (int i = 0; i < 4; i++) {
			tmap[i] = Arrays.copyOf(map[i], 4);
		}
		px = x;
		py = y;
		moveF();
		boolean pass = false;
		while (cnt <= 4) {
			cnt++;
			int nx = x + dx[pos] * cnt;
			int ny = y + dy[pos] * cnt;
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || fdie[map[nx][ny]]) {
				continue;
			}
			fdie[map[nx][ny]] = true;
			eat(nx, ny, fmove[map[nx][ny]], sum + map[nx][ny]);
			map[nx][ny] = map[nx][ny];
			fdie[map[nx][ny]] = false;
		}
		for(int i =1 ; i < 17;i++) {
			fpos[i] =  new Point(tpos[i].x,tpos[i].y);
		}
		fmove = tmove;
		map = tmap;
		if (!pass) {
			max = Math.max(max, sum);
		}

	}

	static void moveF() {
		for (int i = 1; i < 17; i++) {
			if (fdie[i])
				continue;
			int x = fpos[i].x;
			int y = fpos[i].y;
			int pos = fmove[i];

			for (int j = 0; j < 8; j++) {
				int nx = x + dx[pos];
				int ny = y + dy[pos];
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (px == nx && py == ny)) {
					// 방향전환 구현
					pos = (pos + 1) % 8;
					continue;
				}
				int tnum = map[nx][ny];
				map[nx][ny] = map[x][y];
				map[x][y] = tnum;
				fpos[tnum].x = x;
				fpos[tnum].y = y;
				fpos[i].x = nx;
				fpos[i].y = ny;
				fmove[i] = pos;
				break;
			}
		}
	}
}


//	12	9	10	14		
//	16	6	0	1	
//	5	2	15	8	
//	3	13	4	11