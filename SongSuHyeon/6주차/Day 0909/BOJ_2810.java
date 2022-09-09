import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String seats = "";
        seats += "*";
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'S') {
                seats += "S*";
            } else if (s.charAt(i) == 'L') {
                i++;
                seats +="LL*";
            }
        }

        int cnt =0;
        boolean[] visited = new boolean[seats.length()];
        for (int i = 1; i < seats.length()-1; i++) {
            if(seats.charAt(i) == 'S' || seats.charAt(i) == 'L'){
                if(i-1 >= 0) {
                    if(!visited[i-1] && seats.charAt(i-1) == '*'){
                        visited[i-1] = true;
                        cnt++;
                        continue;
                    }
                }
                if(i+1 < seats.length()){
                    if(!visited[i+1]&& seats.charAt(i+1) == '*'){
                        visited[i+1] = true;
                        cnt++;
                    }
                }
            }else{
                continue;
            }

        }

        System.out.println(cnt);
    } // end of main

} // end of class
