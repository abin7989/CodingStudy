import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {

	static int N, M;
	static int[] arr;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (start < arr[i])
				start = arr[i];
			end += arr[i];
		}

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0; // 레슨 합
			int cnt = 0; // 현재 사용한 블루레이 개수

			for (int i = 0; i < N; i++) {
				if (sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				// 현재 블루레이에 저장할 수 없어 새로운 블루레이로 교체
				sum += arr[i];
			}

			if (sum != 0) // 마지막 블루레이가 필요한 경우
				cnt++;

			if (cnt > M) // 모든 레슨 저장이 불가능한 경우
				start = mid + 1;
			else // 중간 인덱스 값으로 모든 레슨 저장 가능한 경우
				end = mid - 1;

		}
		System.out.println(start);
	}

}
