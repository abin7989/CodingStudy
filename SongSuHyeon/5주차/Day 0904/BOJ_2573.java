import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {

    static int N, M, year;
    static int[][] arr, beforeArr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    static class Pointer {
        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0)
                    q.offer(new int[] {i, j, arr[i][j]});
            }
        }

        search();

        System.out.println(year);

    }

    private static void search() {
        year = 0;
        while(!q.isEmpty()) {

            int landCnt = 0;
            visited =new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && arr[i][j] != 0) {
                        landCnt++;
                        dfs(i, j);
                    }
                }
            }

            // 땅이 2개로 분리되면 종료
            if (landCnt >= 2) {
                return;
            }

            // 원본 배열 깊은 복사
            beforeArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(arr[i], 0, beforeArr[i], 0, arr[0].length);
            }

            year++;

            int size=q.size();
            visited =new boolean[N][M];
            for (int t = 0; t < size; t++) {
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];

                if (arr[r][c] != 0 && !visited[r][c]) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if (check(nr, nc)) continue;

                        if (beforeArr[nr][nc] == 0) cnt++;
                    }

                    if (beforeArr[r][c] - cnt < 0)
                        arr[r][c] = 0;
                    else {
                        arr[r][c] = beforeArr[r][c] - cnt;
                        q.offer(new int[]{r, c, arr[r][c]});
                    }
                }
            }
        }

        // queue가 비어 있으면 두덩어리 이상으로 분리되지 않는 경우로 0 출력
        if(q.isEmpty())
            year=0;
    }

    private static void dfs(int r, int c) {

        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (check(nr, nc)) continue;

            if (!visited[nr][nc] && arr[nr][nc] != 0) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }

    }

    private static boolean check(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }

}


