import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_1493_수의새로운연산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = new int[301][301];
			int num = 1;
			for (int j = 1; j < arr.length; j++) {
				int nj = j;
				for (int i = 1; i <= j; i++) {
					arr[nj--][i] = num++;
				}
			}
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int p = Integer.valueOf(st.nextToken());
			int q = Integer.valueOf(st.nextToken());
			
			int new_i = 0, new_j = 0;
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr.length; j++) {
					if(p == arr[i][j]) {
						new_i += i;
						new_j +=j;
					}
				}
				for (int j = 0; j < arr.length; j++) {
					if(q == arr[i][j]) {
						new_i += i;
						new_j += j;
					}
				}
			}
		
			System.out.println("#" + test_case + " " + arr[new_i][new_j]);
		}

	}
}
