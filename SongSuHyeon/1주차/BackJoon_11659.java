package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st= new StringTokenizer(s);
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		String s2 = br.readLine();
		StringTokenizer st2= new StringTokenizer(s2);
		
		int[] arr = new int[N+1];
		int num = 0, sum = 0;
		for (int i = 1; i <= N; i++) {
			num = Integer.valueOf(st2.nextToken());
			sum += num;
			arr[i] = sum;
		}
		
		for (int test_case = 0; test_case < M; test_case++) {
			String s3 = br.readLine();
			StringTokenizer st3= new StringTokenizer(s3);
			int i = Integer.valueOf(st3.nextToken());
			int j = Integer.valueOf(st3.nextToken());
			
			System.out.println(arr[j] - arr[i-1]);
			
		}
	}
}
