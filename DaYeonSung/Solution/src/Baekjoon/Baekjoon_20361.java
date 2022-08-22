package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 20361. 일우는 야바위꾼
public class Baekjoon_20361 {

	static int N, X, K;
	static int cup1, cup2;
	static int[] cups;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
			
        N = Integer.parseInt(st.nextToken()); // 종이컵의 수

        X = Integer.parseInt(st.nextToken()); // 간식 들어있는 종이컵 순서

        K = Integer.parseInt(st.nextToken()); // 컵의 위치를 맞바꾸는 횟수

        cups = new int[N]; // 종이컵 수 크기만큼 cups라는 배열 선언
        cups[X-1] = 1; // 간식 들어있는 종이컵 위치에 해당되는 배열을 1로 초기화 (나머지는 0)

        for (int i = 0; i < K; i++) { // K번 만큼 컵 위치 바꾼다
            st = new StringTokenizer(br.readLine());
            cup1 = Integer.parseInt(st.nextToken()); // 맞바꿀 컵 위치 1
            cup2 = Integer.parseInt(st.nextToken()); // 맞바꿀 컵 위치 2
            swap(cup1, cup2); // 컵 바꾸기!
        }

        for (int i = 0; i < N; i++) {
            if (cups[i] == 1) { // 간식 있는 위치 찾기
                System.out.println(i + 1); // 간식 위치 출력
                break;
            }
        }
		
	}
	
	// 컵 맞바꾸기 함수
	private static void swap(int cup1, int cup2) {
		int tmp = cups[cup1 - 1]; // 하나를 tmp 변수에 저장해뒀다가
		cups[cup1 - 1] = cups[cup2 - 1]; // 두개의 컵 위치 맞바꾸기
		cups[cup2 - 1] = tmp; // 두개의 컵 위치 맞바꾸기
	}

}
