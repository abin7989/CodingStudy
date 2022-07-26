import java.io.*;
import java.util.*;
public class Main_백준_10971_외판원순회2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer(1000);
	static StringTokenizer st;
	static int map[][];
	static int p[];
	static boolean v[];
	static int n;
	static int min = Integer.MAX_VALUE;
	static void prem(int cnt,int sum) {
		
		if(min<sum)
			return;
		if(cnt==n) {
			if(map[p[cnt-1]][p[0]]==0)
				return;
			sum+=map[p[cnt-1]][p[0]];
			min = Math.min(min, sum);
			return ;
		}
		for(int i = 0 ; i< n ; i++) {
			if(cnt==0) {
				if(v[i])
					continue;
				v[i] = true;
				p[cnt] = i;
				prem(cnt+1,0);
				v[i] = false;
			}else {
				if(v[i])
					continue;
				if(map[p[cnt-1]][i]==0)
					continue;
				v[i] = true;
				p[cnt] = i;
				prem(cnt+1,sum+map[p[cnt-1]][i]);
				v[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n];
		p=new int [n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		prem(0,0);
		System.out.println(min);
		
	}
}
