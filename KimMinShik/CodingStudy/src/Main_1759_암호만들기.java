import java.io.*;
import java.util.*;

public class Main_1759_암호만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;
	static char map[];
	static char al[];
	static int n;
	static int m;
	static char ch[] = {'a','e','i','o','u'};
	public static void com(int s, int cnt) {

		if (cnt == m) {
			int acnt=0;
			int bcnt=0;
			boolean pass = false;
			for (int i = 0; i < m; i++) {
				pass = false;
				for(int j=0;j<ch.length;j++) {
					if(al[i]==ch[j]) {
						acnt++;
						pass = true;
					}
				}
				if(!pass)
					bcnt++;
			}
			if(acnt>=1&&bcnt>=2) {
				for(int i = 0; i < m ;i++) {
					sb.append(al[i]);
				}
				sb.append("\n");
			}
			
			return;
		}
		for (int i = s + 1; i < n; i++) {
			al[cnt] = map[i];
			com(i, cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map=new char[n];
		al = new char[n];
		String s = br.readLine();
		for (int i = 0,index = 0; i < n; i++,index+=2) {
			map[i] = s.charAt(index);
		}
		Arrays.sort(map);
		com(-1, 0);
		System.out.println(sb);
	}
}
