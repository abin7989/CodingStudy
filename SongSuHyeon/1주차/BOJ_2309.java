import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}

		Arrays.sort(arr);

		int tall = Arrays.stream(arr).sum();
		Loop1: for (int i = 0; i < 9; i++) {
			tall -= arr[i];
			for (int j = i; j < 9; j++) {
				tall -= arr[j];
				if (tall == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break Loop1;
				} else {
					tall += arr[j];
				}
			}
			tall += arr[i];
		}

		for (int i = 0; i < 9; i++) {
			if (arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}
	}
}
