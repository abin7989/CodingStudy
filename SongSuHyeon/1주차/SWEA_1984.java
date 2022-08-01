
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1984 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.valueOf(st.nextToken());
			}
			
			Arrays.sort(arr);
			arr[0] = 0;
			arr[arr.length-1]=0;
			
			int sum =0;
			for (int i = 0; i < 10; i++) {
				sum+=arr[i];
			}
			
			System.out.println("#" + test_case + " " + Math.round((double)sum/8.0));
		} // end of test_case

	} // end of main
} // end of class
