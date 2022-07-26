import java.util.*;
import java.awt.Point;
import java.io.*;

class Solution_SWEA_홈방범서비스 {
	static Queue<Integer> xq = new ArrayDeque<>();
	static Queue<Integer> yq = new ArrayDeque<>();

	public static void main(String args[]) throws Exception {
		// 400*400*400
		// System.out.println(400*400*400);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder(1000);
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char map[][] = new char[n][n];
			boolean v[][] = new boolean[n][n];
			int dx[] = { 1, -1, 0, 0 };
			int dy[] = { 0, 0, 1, -1 };
			int max = 0;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < n; j++, index += 2) {
					map[i][j] = s.charAt(index);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int sub = 4;
					int fin = -1;
					int home = 0;
					for (int k = 0; k < n; k++) {
						Arrays.fill(v[k], false);
					}
					xq.offer(i);
					yq.offer(j);
					v[i][j] = true;
					while (!xq.isEmpty()) {
						int size = xq.size();
						while (size != 0) {
							int x = xq.poll();
							int y = yq.poll();
							if(map[x][y]=='1') {
								home++;
								fin+=m;
							}
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
								if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny])
									continue;
								v[nx][ny] = true;
								xq.offer(nx);
								yq.offer(ny);
							}
							size--;
						}
						if(fin>=0) {
							max = Math.max(max, home);
						}
						fin -= sub;
						sub+=4;
					}//end while
				}
			}//end for
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}