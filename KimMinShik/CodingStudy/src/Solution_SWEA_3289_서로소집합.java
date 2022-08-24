import java.io.*;
import java.util.*;

public class Solution_SWEA_3289_서로소집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	static int pa[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			pa = new int [n+1];
			for(int i = 1;i<=n;i++) {
				pa[i] = i;
			}
			for(int i = 0 ; i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int test = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				switch (test) {
				case 0:
					union(from,to);
					break;
				case 1:
					if(find(from)==find(to))
						sb.append(1);
					else
						sb.append(0);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static int find(int n) {
		if(pa[n]==n)return n;
		return pa[n] = find(pa[n]);
	}
	static boolean union(int a,int b) {
		int aR = find(a);
		int bR = find(b);
		if(aR==bR)return false;
		pa[bR] = aR;
		return true;
	}
}
