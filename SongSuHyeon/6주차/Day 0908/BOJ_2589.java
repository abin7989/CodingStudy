import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {

    static int N, M, minTime;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    visited = new boolean[N][M];
                    int time = bfs(i, j);
                    minTime = Math.max(minTime, time);
                }
            }
        }
        System.out.println(minTime);

    }  // end of main

    private static int bfs(int r, int c) {
        int ans =0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int j = 0; j < 4; j++) {
                int nr = cur[0] + dr[j];
                int nc = cur[1] + dc[j];

                if (check(nr, nc)) continue;

                if (!visited[nr][nc] && arr[nr][nc] == 'L') {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, cur[2]+1});
                    ans = Math.max(ans, cur[2]+1);
                }
            }
        }
        return  ans;
    }

    private static boolean check(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }

}  // en of class