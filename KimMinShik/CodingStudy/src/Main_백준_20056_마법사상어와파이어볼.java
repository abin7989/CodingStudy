import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_백준_20056_마법사상어와파이어볼 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static List<Fire> f = new LinkedList<Main_백준_20056_마법사상어와파이어볼.Fire>();
	static int map[][];
	static Node nmap[][];
	static int n;
	static List<LinkedList<Fire>> pos = new ArrayList<LinkedList<Fire>>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		nmap = new Node[n][n];
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < n; j++)
				nmap[i][j] = new Node();
		}
		int com = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < com; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			f.add(new Fire(x, y, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
			map[x][y] = 1;
			nmap[x][y].fnum.add(f.get(i));
		}

		for (int tc = 0; tc < k; tc++) {
			Move();
			pos.clear();
			findMap();
			slic();
		}
		int fin = 0;
		for(Fire var : f) {
			fin += var.m;
		}
		System.out.println(fin);
	}

	static void slic() {
		int x = 0;
		int y = 0;
		int m = 0;
		int s = 0;
		int d1 = 0;
		int d2 = 0;
		int psize;
		for (int i = 0, size = pos.size(); i < size; i++) {
			m = 0;
			d1 = 0;
			d2 = 0;
			s = 0;
			for (Fire var : pos.get(i)) {
				x = var.x;
				y = var.y;
				m += var.m;
				s += var.s;
				if (var.d % 2 == 0)
					d2++;
				else
					d1++;
			}
			psize = pos.get(i).size();
			for (Fire var : pos.get(i)) {
				f.remove(var);
			}
			map[x][y] = 0;
			nmap[x][y].fnum.clear();
			if (m / 5 == 0)
				continue;

			s = s / psize;
			m = m / 5;
			Fire f1;
			Fire f2;
			Fire f3;
			Fire f4;
			if (d2 == psize || d1 == psize) {
				f1 = new Fire(x,y,m,s,0);
				f2 = new Fire(x,y,m,s,2);
				f3 = new Fire(x,y,m,s,4);
				f4 = new Fire(x,y,m,s,6);
				f.add(f1);
				f.add(f2);
				f.add(f3);
				f.add(f4);
			}
			else {
				f1 = new Fire(x,y,m,s,1);
				f2 = new Fire(x,y,m,s,3);
				f3 = new Fire(x,y,m,s,5);
				f4 = new Fire(x,y,m,s,7);
				f.add(f1);
				f.add(f2);
				f.add(f3);
				f.add(f4);
			}
			map[x][y] = 4;
			nmap[x][y].fnum.add(f1);
			nmap[x][y].fnum.add(f2);
			nmap[x][y].fnum.add(f3);
			nmap[x][y].fnum.add(f4);
		}
	}

	static void findMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > 1) {
					pos.add(nmap[i][j].fnum);
				}
			}
		}
	}

	static void Move() {
		int x;
		int y;
		int m;
		int s;
		int d;
		int nx;
		int ny;
		for (Fire var : f) {
			x = var.x;
			y = var.y;
			map[x][y]--;
			nmap[x][y].fnum.remove(var);
			m = var.m;
			s = var.s;
			d = var.d;
			nx = s * dx[d] + x;
			ny = s * dy[d] + y;
			if(nx<0)
				nx = n+nx%n;
			if(ny<0)
				ny = n+ny%n;
			if(nx>=n)
				nx%=n;
			if(ny>=n)
				ny%=n;
			map[nx][ny]++;
			nmap[nx][ny].fnum.add(var);
			var.x = nx;
			var.y = ny;
		}
	}

	static class Node {
		LinkedList<Fire> fnum = new LinkedList<Fire>();
	}

	static class Fire {
		int x;
		int y;
		int m;// 질량
		int s;// 이동칸
		int d;// 방향

		public Fire(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}
}
