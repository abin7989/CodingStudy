
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		List<node> al = new ArrayList<Main.node>();
		for(int i = 0 ; i< n ;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			al.add(new node(min,max));
		}
		Collections.sort(al);
		int find = al.get(0).max;
		int cnt =n;
		for(int i = 1;i<n;i++) {
			if(al.get(i).min<=find) {				
				cnt--;
				continue;
			}
			else {
				find = al.get(i).max;
			}
		}
		System.out.println(cnt);
	}
	static class node implements Comparable<node>{
		int min;
		int max;
		public node(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		@Override
		public int compareTo(node o) {
			if(max-o.max!=0)
				return max-o.max;
			else
				return min-o.min;
		}
	}
}