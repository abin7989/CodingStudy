
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
class Solution_SWEA_1954_달팽이숫자_D2_이연수_100ms {
     
    public static void main(String args[]) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dr = { 0, 1, 0, -1 }; // 오른쪽 아래 왼쪽 위
        int[] dc = { 1, 0, -1, 0 }; // 오른쪽 아래 왼쪽 위
         
        for(int testCase = 1; testCase <= T; testCase++) {
             
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N + 2][N + 2];
            int num = 1;
            int direction = 0;
            int nextI = 1;
            int nextJ = 1;
             
            for (int i = 0; i < arr.length; i++) {
                 
                Arrays.fill(arr[i], 1);
                 
            }
 
            for (int i = 1; i < arr.length - 1; i++) {
                 
                for (int j = 1; j < arr.length - 1; j++) {
                     
                    arr[i][j] = 0;
                     
                }
                 
            }
 
            while(num <= N * N) {
                 
                arr[nextI][nextJ] = num++;
 
                if(arr[nextI + dr[direction % 4]][nextJ + dc[direction % 4]] != 0) {
                     
                    direction++;
                     
                }
                 
                nextI += dr[direction % 4];
                nextJ += dc[direction % 4];
                 
            }
             
            sb.append("#").append(testCase).append("\n");
             
            for(int j = 1; j <= N; j++) {
                 
                for(int k = 1; k <= N; k++) {
                     
                    sb.append(arr[j][k]).append(" ");
                     
                }
                 
                sb.append("\n");
                 
            }
             
        }
         
        System.out.print(sb);
         
    }
     
}
 