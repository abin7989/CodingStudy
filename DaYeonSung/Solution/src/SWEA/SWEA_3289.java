package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	
	static int[] arr, size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
		
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			arr = new int[n + 1];
			size = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int how = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(how) {
					case 0: // how가 0이라면
						union(a,b); // a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다
						break;
					case 1: // how가 1이라면
						if(find(a) == find(b)) { // 두 원소가 같은 집합에 포함되어 있는지를 확인
							sb.append(1); // 같은 집합에 속해있다면 1 출력
						} else {
							sb.append(0); // 아니면 0을 출력
						}
						break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static int find(int x) {
		if (arr[x] == x) return x;
		arr[x] = find(arr[x]); 
		return arr[x];
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
    	int pb = find(b);
 
    	if(pa==pb) return;
	 
    	if(size[pa]>size[pb]) arr[pb] = pa;
    	else if(size[pa]==size[pb]) size[pb]++;
 
    	if(size[pb]>size[pa]) arr[pa] = pb;
	}
}
