package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2003. 수들의 합 2
public class Baekjoon_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, cnt = 0, sum = 0;
		
		while(start < N) {
			if(sum > M || end == N) sum -= input[start++];
			else sum += input[end++];
                
			if(sum==M) cnt++;
		}
		
		System.out.println(cnt);
	}
	
}
