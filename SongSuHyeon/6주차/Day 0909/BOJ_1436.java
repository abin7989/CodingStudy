import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int cnt=0;
        for (int i = 666; i <= Integer.MAX_VALUE; i++) {
            String tmp = String.valueOf(i);
            if(tmp.contains("666"))
                cnt++;
            if(cnt == N) {
                System.out.println(i);
                break;
            }
        }
    }

}  // en of class