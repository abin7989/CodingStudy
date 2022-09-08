import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866 {

    static int[] arr,cmp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int cnt = 1;
        sb.append("<");
        while(q.size() != 1){

            if(cnt == K){
                sb.append(q.poll()).append(", ");
                cnt = 1;
            } else{
                int tmp = q.poll();
                cnt++;
                q.offer(tmp);
            }
        }

        sb.append(q.poll()).append(">");

        System.out.println(sb);
    }  // end of main

}  // en of class