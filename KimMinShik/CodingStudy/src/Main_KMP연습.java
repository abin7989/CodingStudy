import java.io.*;
import java.util.*;

public class Main_KMP연습 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);
	static int[] pi;
	static List<Integer> ans = new ArrayList<Integer>();
	static void getpi(String p) {
		int m = p.length();
		int j = 0;
		for(int i = 1 ; i < m;i++) {
			while(j>0&&p.charAt(i)!=p.charAt(j)) {
				j = pi[j-1];				
			}
			
			if(p.charAt(i)==p.charAt(j))
				pi[i]=++j;
		}
	}
	static void kmp(String t, String p ) {
		int n = t.length();
		int m = p.length();
		int j = 0;
		for(int i = 0 ; i<n;i++) {
			while(j>0&&t.charAt(i)!=p.charAt(j)) {
				j= pi[j-1];
			}
			if(t.charAt(i)==p.charAt(j)) {
				if(j==m-1) {
					ans.add(i-m+1);
					j=pi[j];
				}else {
					j++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		String T = br.readLine();
		String P = br.readLine();
		pi = new int[P.length()];
		getpi(P);
		kmp(T,P);
		sb.append(ans.size()).append("\n");
		for(int var : ans) {
			sb.append(var+1).append(" ");
			
		}
		System.out.println(sb);
	}
}
