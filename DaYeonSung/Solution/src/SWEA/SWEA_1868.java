package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
* 
* * 지뢰가 있다
* . 지뢰가 없다
*
*/

//SWEA 1868. 파핑파핑 지뢰찾기
public class SWEA_1868 {
 
    static int N, totalCnt;
    static char[][] map;
    static int[][] cntmap;
    static boolean[][] visited;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            totalCnt = 0;
             
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            cntmap = new int[N][N];
            visited = new boolean[N][N];
             
            for (int r = 0; r < N; r++) {
                map[r] = br.readLine().toCharArray();
            }
            
            // 지뢰 세기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    cntAround(r, c);
                }
            }
             
            // 0 먼저 누르기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (cntmap[r][c] == 0 && !visited[r][c]) {
                        totalCnt++;
                        pressZero(r, c);
                    }
                }
            }
            
            for (int r = 0; r < N; r++) {
				System.out.println(Arrays.toString(cntmap[r]));
			}
             
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(!visited[r][c] && map[r][c] != '*') {
                        totalCnt++;
                    }
                }
            }
            sb.append(totalCnt).append("\n");
            
        }
        System.out.println(sb);
    }
     
    private static void cntAround(int r, int c) {
        int cnt = 0;
        if (map[r][c] == '*') {
            cntmap[r][c] = -1;
            return;
        }
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
             
            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
             
            if (map[nr][nc] == '*') cnt++;
        }
        cntmap[r][c] = cnt;
    }
     
    private static void pressZero(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
             
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == '*' || visited[nr][nc])
            	continue;

            visited[nr][nc] = true; // 8방향 방문 처리
            
            if (cntmap[nr][nc] == 0)
            	pressZero(nr, nc);
            
            
        }
    }
 
}