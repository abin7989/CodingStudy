

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine());
			String map[] = new String[n];
			StringTokenizer st = new StringTokenizer( br.readLine());
			for(int i = 0 ; i < n ; i++) {
				map[i] = st.nextToken();
			}
			System.out.printf("#%d ",test_case);
			int p = 0;
			boolean pass = true;
			if(n%2!=0) {
				p=1;
				pass = false;
			}
			int pos = n/2+p;
			for(int i = 0; i<n/2;i++) {
				System.out.printf("%s ",map[i]);
				System.out.printf("%s ",map[pos++]);
			}
			if(!pass)
				System.out.printf("%s ",map[n/2]);
			System.out.println();
		}
	}
}
