import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {

    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr=new char[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                char[] c1 = {'W', 'B'};
                char[] c2 = {'B', 'W'};
                int cnt = 0;
                int ans1 = 0, ans2 = 0;
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {

                        if(cnt%2 ==0){
                            if(c1[cnt%2] != arr[k][l])
                                ans1++;
                        }else{
                            if(c1[cnt%2] != arr[k][l])
                                ans1++;
                        }

                        if(cnt%2 ==0){
                            if(c2[cnt%2] != arr[k][l])
                                ans2++;
                        }else{
                            if(c2[cnt%2] != arr[k][l])
                                ans2++;
                        }
                        cnt++;
                    }
                    cnt++;
                }

                min = Math.min(min, ans1);
                min = Math.min(min, ans2);

            }
        }
        System.out.println(min);
    } // end of main

} // end of class
