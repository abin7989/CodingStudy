package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// น้มุ 10866. ตฆ
public class Baekjoon_10866 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> deque = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			
			switch(str) {
			case("push_front"):
				int front = Integer.parseInt(st.nextToken());
				deque.push(front);
				break;
			case("push_back"):
				int back = Integer.parseInt(st.nextToken());
				deque.add(back);
				break;
			case("pop_front"):
				if (deque.size() == 0) sb.append(-1).append("\n");
				else sb.append(deque.pollFirst()).append("\n");
				break;
			case("pop_back"):
				if (deque.size() == 0) sb.append(-1).append("\n");
				else sb.append(deque.pollLast()).append("\n");
				break;
			case("size"):
				sb.append(deque.size()).append("\n");
				break;
			case("empty"):
				if (deque.size() == 0) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case("front"):
				if (deque.size() == 0) sb.append(-1).append("\n");
				else sb.append(deque.peekFirst()).append("\n");
				break;
			case("back"):
				if (deque.size() == 0) sb.append(-1).append("\n");
				else sb.append(deque.peekLast()).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
	}

}
