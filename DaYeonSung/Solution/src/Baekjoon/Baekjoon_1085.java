package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1085. 직사각형에서 탈출
public class Baekjoon_1085 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		// 상 하 비교
		
		int ud = 0;
		int lr = 0;
		
		ud = h - y < y ? h - y : y;
		lr = w - x < x ? w - x : x;
		
		int ans = ud < lr ? ud : lr;
		
		System.out.println(ans);
	}
	
}
