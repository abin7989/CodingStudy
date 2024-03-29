import java.io.*;
import java.util.*;

public class Main_백준_9663_NQueen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	static int n;
	static int map[][];
	static int v[];
	static int max = 0;
	static boolean vch(int c) {
		for(int i=0;i<c;i++) {
			if(v[c]==v[i]||c-i==Math.abs(v[c]-v[i]))
				return false;
		}
		return true;
	}
	static void perm(int cnt) {
		if(cnt==n) {
			max++;
			return;
		}
		for(int i = 0 ; i< n ; i++) {
			v[cnt] = i;
			if(vch(cnt)) {
				perm(cnt+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new int[n];
		perm(0);
		System.out.println(max);
	}

}
