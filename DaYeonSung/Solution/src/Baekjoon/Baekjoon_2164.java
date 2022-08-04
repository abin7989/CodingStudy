package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 백준 2164. 카드2
public class Baekjoon_2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
//		6 5 4 3 2 1 위
//		1 버리기
//		6 5 4 3 2
//		2를 제일 아래로
//		2 6 5 4 3
//		3 버리기
//		2 6 5 4
//		4를 제일 아래로
//		4 2 6 5
//		5 버리기
//		4 2 6
//		6을 제일 아래로
//		6 4 2
//		2 버리기
//		6 4
//		4 제일 아래로
//		4 6
//		6 버리기
//		4
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		while (deque.size() > 1) {
			deque.pollFirst();
			deque.offerLast(deque.pollFirst());
		}
		System.out.println(deque.poll());
	}
}
