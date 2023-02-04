package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1969. DNA
public class Baekjoon_1969 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] words = new char[N][M];
		
		// A T G C
		
		String str = "";
		int hamming_dist = 0;
		
		for (int r = 0; r < N; r++) {
			words[r] = br.readLine().toCharArray();
		}
		
		int[] cnt = new int[4];
		
		for (int c = 0; c < M; c++) {
			cnt = new int[4];
			for (int r = 0; r < N; r++) {
				switch(words[r][c]) {
				case 'A':
					cnt[0]++;
					break;
				case 'C':
					cnt[1]++;
					break;
				case 'G':
					cnt[2]++;
					break;
				case 'T':
					cnt[3]++;
					break;
				}
			}
						
			int maxIdx = 0;
			int maxCnt = 0;
			
			for (int i = 0; i < 4; i++) {
				if (cnt[i] > maxCnt || (cnt[i] == maxCnt && i < maxIdx)) {
					maxIdx = i;
					maxCnt = cnt[i];
				}
			}
			
			switch(maxIdx) {
			case 0:
				str += "A";
				break;
			case 1:
				str += "C";
				break;
			case 2:
				str += "G";
				break;
			case 3:
				str += "T";
				break;
			}
			
			hamming_dist += N - maxCnt;
		}
		
		System.out.println(str);
		System.out.println(hamming_dist);
		
		
		
	}

}
