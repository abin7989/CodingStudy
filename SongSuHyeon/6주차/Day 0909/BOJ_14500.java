import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14500 {

    static int N, M, max=Integer.MIN_VALUE;
    static int[][] arr;
    static ArrayList<Integer> list = new ArrayList<>();

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
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                block1(i, j);
                block2(i, j);
                block3(i, j);
                block4(i, j);
                block5(i, j);
            }
        }

        System.out.println(max);

    } // end of main

    private static void block5(int r, int c) {
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            int nr = r;
            int nc = c + i;

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag){
            int[] dr = {-1, 1};
            int[] dc = {1, 1};

            for (int i = 0; i < 2; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(check(nr, nc)) continue;

                sum+=arr[nr][nc];
                max = Math.max(max, sum);
                sum -= arr[nr][nc];
            }
        }

        sum = 0;
        flag = true;
        for (int i = 0; i < 3; i++) {
            int nr = r+i;
            int nc = c;

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag){
            int[] dr = {1, 1};
            int[] dc = {1, -1};

            for (int i = 0; i < 2; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(check(nr, nc)) continue;

                sum+=arr[nr][nc];
                max = Math.max(max, sum);
                sum -= arr[nr][nc];
            }
        }
    }

    private static void block4(int r, int c) {
        int sum = 0;
        boolean flag = true;
        int[] dr = {0, 1, 1, 2};
        int[] dc = {0, 0, 1, 1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag)
            max = Math.max(max, sum);

        sum = 0;
        flag = true;
        dr = new int[] {0, 1, 1, 2};
        dc = new int[] {0, -1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag)
            max = Math.max(max, sum);

        sum = 0;
        flag = true;
        dr = new int[] {0, 0, 1, 1};
        dc = new int[] {0, 1, 1, 2};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag)
            max = Math.max(max, sum);

        sum = 0;
        flag = true;
        dr = new int[] {0, 0, 1, 1};
        dc = new int[] {0, 1, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag)
            max = Math.max(max, sum);
    }

    private static void block3(int r, int c) {
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            int nr = r;
            int nc = c + i;

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag){
            int[] dr = {-1, 1, -1 , 1};
            int[] dc = {0, 0, 2, 2};

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(check(nr, nc)) continue;

                sum+=arr[nr][nc];
                max = Math.max(max, sum);
                sum -= arr[nr][nc];
            }
        }

        sum = 0;
        flag = true;
        for (int i = 0; i < 3; i++) {
            int nr = r+i;
            int nc = c;

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag){
            int[] dr = {2, 2, 0, 0};
            int[] dc = {-1, 1, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(check(nr, nc)) continue;

                sum+=arr[nr][nc];
                max = Math.max(max, sum);
                sum -= arr[nr][nc];

            }
        }
    }

    private static void block2(int r, int c) {
        int sum = 0;
        boolean flag = true;
        int[] dr = {0, 0, 1, 1};
        int[] dc = {0, 1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag)
            max = Math.max(max, sum);
    }


    private static void block1(int r, int c) {
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int nr = r;
            int nc = c + i;

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag)
            max = Math.max(max, sum);

        sum = 0;
        flag = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + i;
            int nc = c;

            if (check(nr, nc)) {
                flag = false;
                break;
            }
            sum += arr[nr][nc];
        }
        if(flag)
            max = Math.max(max, sum);

    }

    private static boolean check(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }


}  // en of class