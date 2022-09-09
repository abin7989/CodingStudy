import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        boolean flag =false;
        for (int i = 1; i <= N; i++) {
            int num = i;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                num += Integer.parseInt(String.valueOf(s.charAt(j)));
            }
            if(N == num){
                flag = true;
                System.out.println(i);
                break;
            }
        }

        if(!flag)
            System.out.println(0);

    } // end of main

} // end of class
