import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= n; i++) {

            String s = String.valueOf(i);
            int[] arr = new int[s.length()];


            if(s.length() == 1 || s.length()==2) {
                cnt++;
                continue;
            }

            for (int j = 0; j < s.length(); j++) {
                arr[j] = s.charAt(j);
            }

            if(s.length()==3) {
                if(arr[0]-arr[1] == arr[1]-arr[2])
                    cnt++;
            } else if(s.length()==4) {
                if(arr[0]-arr[1] == arr[1] -arr[2] && arr[1] -arr[2] == arr[2] - arr[3])
                    cnt++;
            }

        }
        System.out.println(cnt);

    }
}
