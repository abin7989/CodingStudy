import java.io.*;
import java.util.*;

public class Main_백준_17472_다리만들기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;
	static int map[][];
	static int par[];
	static char tempMap[][];
	static boolean v[][];
	static int n;
	static int m;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int w;

		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return w - o.w;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		tempMap = new char[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < m; j++, index += 2) {
				tempMap[i][j] = s.charAt(index);
			}
		}
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j] || tempMap[i][j] == '0')
					continue;
				makeMap(i, j, cnt++);
			}
		}
		par = new int[cnt];
		for(int i = 1 ; i<cnt;i++) {
			par[i]=i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m ; j++) {
				if(map[i][j]!=0) {
					makeL(i,j,-1,0);
					makeL(i,j,1,0);
					makeL(i,j,0,-1);
					makeL(i,j,0,1);
				}
				
			}
		}
		
		System.out.println(ka(cnt));
		return;
	}
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static void makeMap(int x, int y, int cnt) {
		if (v[x][y])
			return;
		v[x][y] = true;
		map[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || tempMap[nx][ny] == '0')
				continue;
			makeMap(nx, ny, cnt);
		}
	}

	static void makeL(int x, int y,int dx,int dy) {
		int cnt = 0;
		int now = map [x][y];
		while (true) {
			int nx = x+dx;
			int ny = y+dy;
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] ==now)
				return;
			if(map[nx][ny]!=0&&cnt>1) {
				pq.add(new Edge(now,map[nx][ny],cnt));
				return;
			}else if(map[nx][ny]!=0) {
				return;
			}
			cnt++;
			x = nx;
			y = ny;
		}
	}
	static int find(int a) {
		if(par[a] == a )return a;
		return par[a] = find(par[a]); 
	}
	static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if(aR == bR) return false;
		par[bR] = aR;
		return true;
	}
	static int ka(int size) {
		int result = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(union(edge.from,edge.to)) {
				result +=edge.w;
				if(++count == size-2) return result;
			}
		}
		return -1;
	}
}
