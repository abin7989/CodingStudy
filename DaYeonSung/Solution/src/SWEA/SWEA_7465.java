package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 7465. 창용 마을 무리의 개수
public class SWEA_7465 {

	static int graph[][];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new int[N+1][N+1];
			
			int ans = 1;
			visited = new boolean[N+1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				graph[num1][num2] = 1;
				graph[num2][num1] = 1;
			}
			
            for(int i = 1; i< N + 1; i++){
                if(!visited[i]){
                    dfs(i, N+1);
                    for(int j = 1; j< N + 1; j++) {
                        if(!visited[j]) {
                            ans++;
                            break;
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void dfs(int idx, int tot) {
        if(!visited[idx]) {
           visited[idx] = true;
           for(int i = 1; i < tot; i++){
               if(graph[idx][i] == 1 && !visited[i]) {
            	   dfs(i, tot);
               }
           }
        }
    }
	
}
