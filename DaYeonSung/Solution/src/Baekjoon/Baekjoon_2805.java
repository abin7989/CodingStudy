package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2805. 나무 자르기
public class Baekjoon_2805 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); //  상근이가 집으로 가져가려고 하는 나무의 길이
		
		//  절단기에 설정할 수 있는 높이의 최댓값 구하기
		
		int min = 0;
		int max = 0;
		
		int[] trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < trees.length; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			
			if (max < trees[i]) {
				max = trees[i];
			}
		}
		
		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;
			for (int i = 0; i < trees.length; i++) {
				if (trees[i] - mid > 0) {
					sum += (trees[i] - mid);
				}
			}
			if (sum < M) { // 나무 길이 합계가 M에 못미치면
				max = mid; // max값을 mid로 바꾸기
			} else { // 크거나 같으면
				min = mid + 1; // 최소 길이 업데이트
			}
		}
		
		System.out.println(min - 1);
		
	}

}
