import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_1220 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.valueOf(br.readLine());
            int[][] table = new int[100][100];
            for (int i = 0; i < 100; i++) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                for (int j = 0; j < 100; j++) {
                    table[i][j] = Integer.valueOf(st.nextToken());
                }
            }
 
            int cnt = 0;
            boolean flag = false;
            for (int i = 0; i < 100; i++) {  // N극인 경우만 고려
                flag = false;
                for (int j = 0; j < 100; j++) {
                    if (table[j][i] == 1) { 
                        flag = true;
                    } 
                    else if(table[j][i] == 2 && flag) {
                        flag = false;
                        cnt++;
                    }
                }
            }
             
            System.out.println("#" + test_case + " " + cnt);
        } // end of test_case
 
    } // end of main
} // end of class