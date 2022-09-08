import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250 {

    static int[][] arr;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());  // 호텔의 층 수
            int W = Integer.parseInt(st.nextToken());  // 각 층의 방 수
            int N = Integer.parseInt(st.nextToken());  // 몇 번째 손님


            arr = new int[H + 2][W + 2];

            for (int i = 1; i <= H+1; i++) {
                for (int j = 1; j <= W+1; j++) {
                    arr[i][j] = i * 100 + j;
                }
            }

            int cnt = 0;
            loop:      for (int i = 1; i <= W; i++) {
                for (int j = 1; j <= H; j++) {
                    cnt++;
                    if(cnt == N){
                        sb.append(arr[j][i]).append("\n");
                        break loop;
                    }
                }
            }

        }  // end of tc
        System.out.println(sb);
    }  // end of main

}  // en of class