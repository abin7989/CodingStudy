import java.io.*;
import java.util.*;

public class Solution_연습_ShuffleOMatic {
	
	static BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);
	static Queue<int []> queue = new ArrayDeque<int []>();
	static Set<String> set = new HashSet<>();
	static int n;
	static Integer[] o1;
	static Integer[] o2;
	static String t = "";
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(bReader.readLine());
		for(int test_case  = 1;test_case<=T;test_case++) {
			sb.append("#").append(test_case).append(" ");
			n = Integer.parseInt(bReader.readLine());
			int map[] = new int [n];
			o1 = new Integer[n];
			o2 = new Integer[n];
			st = new StringTokenizer(bReader.readLine()," ");
			for(int i = 0 ; i < n ; i++) {
				map[i] = Integer.parseInt(st.nextToken());
				o1[i] = map[i];
				o2[i] = map[i];
			}
			Arrays.sort(o1);
			Arrays.sort(o2,Collections.reverseOrder());

			queue.clear();
			set.clear();
			t = "";
			boolean pass = false;
			if(!ch(map)) {
				queue.add(Arrays.copyOf(map, n));
			}else {
				pass =true;
			}
			set.add(t);
			int cnt = 0;
			int size = 0;
			int[] l = new int [n/2];
			int[] r = new int [n/2];
			int[] make = new int[n];
			bw:while(!queue.isEmpty()) {
				size = queue.size();
				cnt++;
				while(size-->0) {
					int [] temp = queue.poll();
					
					System.arraycopy(temp, 0, l, 0,n/2);
					System.arraycopy(temp,n/2, r, 0,n/2);
					for(int i = 1 ; i < n;i++) {
						sp(l,r,i,make);
						t = "";
						if(ch(make)) {
							pass = true;
							break bw;
						}
						if(!set.contains(t))
							set.add(t);
						else
							continue;
						queue.offer(Arrays.copyOf(make, n));
					}
				}
				if(cnt>5)
					break;
			}
			if(cnt>5||!pass)
				sb.append("-1\n");
			else
				sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	static boolean ch (int m[]) {
		boolean pass1 = true;
		boolean	pass2 = true;
		for(int j = 1 ; j < n ; j++) {
			t+=m[j];
			if(o1[j]!=m[j])
				pass1 = false;
			if(o2[j]!=m[j])
				pass2 = false;
		}
		if(pass1||pass2) {
			return true;
		}
		
		return false;
	}
	static void sp(int[] l,int[] r, int num, int[] out_arr ) {
		int[] temp = new int[n*2];
		for(int i = l.length-1;i>=0;i--) {
			temp[i+num]= l[i];
			num = Math.max(0, --num);
		}
		int pos = 0;
		for(int i = 0;i<n;i++) {
			if(temp[i]==0) {
				temp[i] = r[pos++];
				if(pos==n/2)
					break;
			}
		}
		pos = 0;
		for(int i = 0 ; i < temp.length;i++) {
			if(temp[i]!=0) {
				out_arr[pos++] = temp[i];
			}
		}
		
	}
}