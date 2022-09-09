import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1966 {

    static int T;
    static StringBuilder sb = new StringBuilder();

    static public class Doc {
        int score;
        int num;

        public Doc(int score, int num) {
            this.score = score;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());  // 문서의 개수 N(1 ≤ N ≤ 100)
            int M = Integer.parseInt(st.nextToken());  // 몇 번째 문서

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Doc> q = new LinkedList<>();
            int[] nums = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                int score = Integer.parseInt(st.nextToken());
                q.offer(new Doc(score, i));
                pq.offer(score);
                nums[i-1] = i;
            }

            int cnt = 0;
            int num = nums[M];
            loop1: while(!pq.isEmpty()) {
                int score = pq.poll();

                loop2: while(!q.isEmpty()){

                    Doc cur = q.poll();
                    if(score == cur.score && num  == cur.num){
                        cnt++;
                        break loop1;
                    }

                    if(score == cur.score){
                        cnt++;
                        break loop2;
                    }else{
                        q.offer(cur);
                    }
                }
            }

            sb.append(cnt).append("\n");

        }  // end of testCase

        System.out.println(sb);

    } // end of main

}  // en of class