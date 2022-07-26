import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
class Solution_SWEA_2805_농작물수확하기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine());
			int map[][] = new int [n][n];
			boolean v[][] = new boolean [n][n];
			for(int i = 0 ; i < n ; i++) {
				String st = br.readLine();
				for(int j = 0; j< n ; j++) {
					map[i][j] = st.charAt(j)-'0';
				}
			}
			
			int dx[] ={1,0,-1,0};
			int dy[] = {0,1,0,-1};
			Queue<Point> q = new LinkedList<>();
			Queue<Integer> cq = new LinkedList<>();
			q.add(new Point(n/2,n/2));
			cq.add(0);
			int fin = 0;
			while(!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.poll().y;
				int cnt = cq.poll();
				if(cnt>n/2||v[x][y]) {
					continue;
				}
				v[x][y] = true;
				fin+=map[x][y];
				for(int i = 0 ; i < 4;i++) {
					int nx = x+dx[i];
					int ny = y + dy[i];
					if(nx<0||nx>=n||ny<0||ny>=n||v[nx][ny]) continue;
					
					q.add(new Point(nx,ny));
					cq.add(cnt+1);
				}
			}
			System.out.printf("#%d %d\n",test_case,fin);
		}
		
	}
}