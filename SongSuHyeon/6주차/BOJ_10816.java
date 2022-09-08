import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816 {

    static int[] arr,cmp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map1 = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map1.containsKey(num)){
                map1.put(num, map1.get(num)+1);
            }else{
                map1.put(num, 1);
            }
        }


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int cmp = Integer.parseInt(st.nextToken());
            if (map1.containsKey(cmp)) {
                sb.append(map1.get(cmp)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);


    }  // end of main

}  // en of class