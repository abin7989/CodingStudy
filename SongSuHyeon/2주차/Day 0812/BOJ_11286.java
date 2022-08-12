import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {

	public static class Pair implements Comparable<Pair> {
		int first, second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Pair p) { // 첫번째꺼로 오름차순 만약 값이 같다면 두번째꺼로 오름차순
			if (this.first == p.first)
				return Integer.compare(this.second, p.second);
			else
				return Integer.compare(this.first, p.first);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
		PriorityQueue<Pair> priorityQueueLowest = new PriorityQueue<>();
		Pair test;
		int N = Integer.valueOf(br.readLine()); // 연산의 개수 N
		for (int i = 0; i < N; i++) {
			int x = Integer.valueOf(br.readLine());

			// 만약 x가 0이 아니라면 배열에 x라는 값 추가
			if (x != 0) {
				priorityQueueLowest.add(new Pair(Math.abs(x), x));
			} else {
				// x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
				// 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거

				if (priorityQueueLowest.isEmpty()) {
					System.out.println(0); // 배열이 비어 있는 경우 : 0을 출력
				} else {
					test = priorityQueueLowest.poll();
					System.out.println(test.second);
				}
			}
		}

	} // end of main

} // end of class
