import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution_연습_헌터 {
	static BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sBuilder = new StringBuilder(1000);
	static StringTokenizer stringTokenizer;
	static int map[][];
	static List<Point> point= new ArrayList<Point>();
	static boolean v[];
	static boolean mv[];
	static Point pr[];
	static int n;
	static int px = 1;
	static int py = 1;
	static int homeAndMonsterSize = 0;
	static int min = Integer.MAX_VALUE;
	static void prem(int cnt) {
		if (cnt == homeAndMonsterSize) {
			int temp = 0;
			px = 1;
			py = 1;
			Arrays.fill(mv, false);
			for(int i = 0 ; i < homeAndMonsterSize ; i++) {
				Point p = pr[i];
				if(map[p.x][p.y]>0) {
					temp+=Math.abs(px-p.x)+Math.abs(py-p.y);
					mv[map[p.x][p.y]] =true;
					px = p.x;
					py = p.y;
				}else {
					if(mv[-map[p.x][p.y]]) {
						temp+=Math.abs(px-p.x)+Math.abs(py-p.y);
						px = p.x;
						py = p.y;
					}else {
						return;
					}
				}
			}
			min= Math.min(min, temp);
			return;
		}
		for (int i = 0; i < homeAndMonsterSize; i++) {
			if (v[i])
				continue;
			v[i] = true;
			pr[cnt] = point.get(i);
			prem(cnt + 1);
			v[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sBuilder.append("#").append(test_case).append(" ");
			n = Integer.parseInt(bReader.readLine());
			map = new int[n + 1][n + 1];
			point.clear();
			for (int i = 1; i <= n; i++) {
				stringTokenizer = new StringTokenizer(bReader.readLine(), " ");
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
					if (map[i][j] > 0) {
						point.add(new Point(i,j));
					}
					else if (map[i][j] < 0) {
						point.add(new Point(i,j));
					}
				}
			}
			homeAndMonsterSize =  point.size();
			v = new boolean[homeAndMonsterSize];
			mv = new boolean[homeAndMonsterSize/2+1];
			pr = new Point[homeAndMonsterSize];
			min = Integer.MAX_VALUE;
			prem(0);
			sBuilder.append(min).append("\n");
		}
		System.out.println(sBuilder);
	}
}
