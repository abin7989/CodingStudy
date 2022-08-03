package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 2070. 큰 놈, 작은 놈, 같은 놈
public class SWEA_2070 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if (n1 < n2) {
				sb.append("#").append(tc).append(" ").append("<\n");
			} else if (n1 == n2) {
				sb.append("#").append(tc).append(" ").append("=\n");
			} else if (n1 > n2) {
				sb.append("#").append(tc).append(" ").append(">\n");
			}
			
		}
		System.out.print(sb);
	}
}
