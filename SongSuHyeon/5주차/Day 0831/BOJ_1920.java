import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

	static int N, M, num;
	static int[] arr, cmp;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());

			boolean find = false;
			int start = 0;
			int end = N - 1;

			while (start <= end) {

				int mid = (start + end) / 2;

				if (target < arr[mid]) // target보다 중앙 값이 크면 end 줄이기
					end = mid - 1;

				else if (target > arr[mid]) // target보다 중앙 값이 작으면 start 늘리기
					start = mid + 1;

				else {
					find = true;
					break;
				}

			}

			if (find)
				System.out.println(1);
			else
				System.out.println(0);
		}

	}

}
