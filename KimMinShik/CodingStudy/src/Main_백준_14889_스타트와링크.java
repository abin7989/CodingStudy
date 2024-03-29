import java.io.*;
import java.util.*;

public class Main_백준_14889_스타트와링크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(100);
	static StringTokenizer st;
	static int map[][];
	static boolean v[];
	static int n;
	static int min = Integer.MAX_VALUE;
	static int size;
	static int total;
	public static void combi(int s,int cnt) {
		if (cnt == size) {
			sum();
			return;
		}

		for (int i = s+1; i < n; i++) {
			v[i] = true;
			combi(i,cnt + 1);
			v[i] = false;
		}
	}
	public static void sum () {
		int temp  = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = i+1 ; j<n;j++) {
				if(v[i]&&v[j]) {
					temp+=map[i][j]+map[j][i];
					
				}
				if(!v[i]&&!v[j]) {
					temp-=map[i][j]+map[j][i];
				}
			}
		}
		min = Math.min(min, Math.abs(temp));
	}
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		size =n/2;
		map = new int[n][n];
		v = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(-1,0);
		System.out.println(min);
	}
}
