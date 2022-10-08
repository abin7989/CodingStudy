package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 SW 역량 테스트 기출 문제
// 백준 13458. 시험 감독
public class Baekjoon_13458 {
	
	/*
	 * 감독관은 총감독관, 부감독관이 있음
	 * 총감독관은 한 시험장에서 감시할 수 있는 응시자 수가 B명이고
	 * 부감독관은 한 시험장에서 감시할 수 있는 응시자 수가 C명이다.
	 * 각각의 시험장에 총감독관은 무조건 1명
	 * 부감독관은 여러명 가능
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] students = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < students.length; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		double B = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		
		long cnt = 0;
		for (int num : students) {
			if ((num - B) <= 0) cnt++;
			else cnt += Math.ceil((num - B) / C) + 1;
		}
		
		System.out.println(cnt);
		
	}

}
