import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1860 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.valueOf(st.nextToken());
			int M = Integer.valueOf(st.nextToken());
			int K = Integer.valueOf(st.nextToken());
			
			int[] customer = new int[N];
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				customer[i] = Integer.valueOf(st2.nextToken());
			}
			
			Arrays.sort(customer);  // 손님들이 오는 시간 정렬
			
			int cnt = 0;
			boolean check = true;
			for (int i = 0; i < N; i++) {
				cnt = (customer[i] / M) * K;
				if(cnt < i+1) {
					check = false;
					break;
				}
			}
			
			if(check)
				System.out.println("#" + test_case + " Possible");
			else
				System.out.println("#" + test_case + " Impossible");
		}
	}
}
