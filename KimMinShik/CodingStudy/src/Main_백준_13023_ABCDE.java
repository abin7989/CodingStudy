import java.io.*;
import java.util.*;

public class Main_백준_13023_ABCDE {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;
	static List<Integer>[] map;
	static boolean v[];
	static void DFS(int num,int cnt) {
		if(cnt==4) {
			System.out.println(1);
			System.exit(0);
		}
		for(int i = 0,size =map[num].size();i<size;i++) {
			if(v[map[num].get(i)])
				continue;
			v[num] = true;
			DFS(map[num].get(i),cnt+1);
			v[num] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n];
		v = new boolean[n];
		int from=0;
		int to=0;
		for(int i = 0 ; i<n;i++) {
			map[i]= new ArrayList<Integer>();
		}
		for(int i = 0 ; i <m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			map[from].add(to);
			map[to].add(from);
		}
		for(int i =0;i<n;i++) {
			Arrays.fill(v, false);
			v[i] = true;
			DFS(i,0);
		}

		System.out.println(0);
	}
}
