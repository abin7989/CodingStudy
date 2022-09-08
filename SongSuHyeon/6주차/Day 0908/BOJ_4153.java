import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153 {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0)
                break;

            boolean flag = false;

            if (a * a + b * b == c * c)
                flag = true;
            else if (a * a + c * c == b * b)
                flag = true;
            else if (b * b + c * c == a * a)
                flag = true;

            if (flag)
                System.out.println("right");
            else
                System.out.println("wrong");


        }  // end of tc

    }  // end of main

}  // en of class