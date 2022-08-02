import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.valueOf(br.readLine());
			int half = N / 2;

			String[] arr = new String[N];
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}

			Deque<String> deque = new ArrayDeque<>();
			if (N % 2 == 0) {
				for (int i = 0; i < half; i++) {
					deque.add(arr[i]);
					deque.add(arr[i + half]);
				}
			} else {
				for (int i = 0; i < half; i++) {
					deque.add(arr[i]);
					deque.add(arr[half + i + 1]);
				}
				deque.add(arr[half]);
			}
			
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(deque.removeFirst()+" ");
			}
			System.out.println();

		}

	}
}
