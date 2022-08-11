package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1938. 아주 간단한 계산기
public class SWEA_1938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		sb.append(a+b).append("\n");
		sb.append(a-b).append("\n");
		sb.append(a*b).append("\n");
		sb.append(a/b).append("\n");
		
		System.out.println(sb);

	}

}
