import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1204 {
	static int[] arr = new int[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int t = Integer.valueOf(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 1000; i++) {
				arr[Integer.valueOf(st.nextToken())]++;
			}
			
			int max = arr[0], index = 0;
			for (int i = 0; i < 101; i++) {
				if(max <= arr[i]) {
					max = arr[i];
					index = i;
				}
			}
			sb.append("#").append(test_case).append(" ").append(index).append("\n");
			Arrays.fill(arr, 0);
		}
		System.out.println(sb);
	}
}
