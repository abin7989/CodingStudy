import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_9020 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(br.readLine());

		int size = 10001;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}

		for (int i = 2; i < Math.sqrt(size); i++) {
			if (arr[i] == 0)
				continue;

			for (int j = i + i; j < size; j += i) {
				arr[j] = 0;
			}
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			int start = 2;
			int end = N;
			while (true) {
				end--;
				if (arr[end] != 0) {
					break;
				}
			}

			ArrayList<int[]> list = new ArrayList<>();
			boolean flag = false;

			while (start <= end) {

				if (start + end > N) {
					while (true) {
						end--;
						if (arr[end] != 0)
							break;
					}
				}

				else if (start + end < N) {
					while (true) {
						start++;
						if (arr[start] != 0)
							break;
					}
				} else {
					flag = true;
					list.add(new int[] { start, end });

					loop: while (start <= end) {
						while (true) {
							start++;
							if (arr[start] != 0)
								break;
						}

						while (true) {
							end--;
							if (arr[end] != 0)
								break loop;
						}
					}

				}

			}
			sb.append(list.get(list.size()-1)[0]).append(" ").append(list.get(list.size()-1)[1]).append("\n");
		}
		System.out.println(sb);
	}
}
