
import java.io.*;
import java.util.*;

public class Main_백준_10819_차이를최대로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);
	static int map[];

	static void swap(int a, int b) {
		int temp = map[a];
		map[a] = map[b];
		map[b] = temp;
	}

	static boolean next_Perm() {
		int i, j, k;
		i = j = k = map.length - 1;
		while (i > 0 && map[i - 1] >= map[i])
			i--;
		if (i == 0)
			return false;
		while (map[i - 1] >= map[j])
			j--;
		swap(i - 1, j);
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		map = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);
		int temp = 0;
		do {
			temp = 0;
			for (int i = 1; i < n; i++) {
				temp+=Math.abs(map[i-1]-map[i]);
			}
			max = Math.max(max,temp);
		} while (next_Perm());
		System.out.println(max);
	}
}
