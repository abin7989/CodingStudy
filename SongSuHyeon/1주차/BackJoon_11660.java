package day_0803;
/*
   더 효율적인 풀이 : Sum[ i ][ j ] = Sum[ i ][ j - 1 ] + Sum[ i - 1 ][ j ] + arr[ i ][ j ] - Sum[ i - 1 ][ j - 1 ]
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		int[][] arr = new int[N+2][N+2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i][j-1] + Integer.valueOf(st2.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.valueOf(st2.nextToken());
			int y1 = Integer.valueOf(st2.nextToken());
			int x2 = Integer.valueOf(st2.nextToken());
			int y2 = Integer.valueOf(st2.nextToken());
			
			int sum = 0;
			for (int j = x1; j <= x2; j++) {
				sum += arr[j][y2] - arr[j][y1-1];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}	// end of main
}  // end of class
