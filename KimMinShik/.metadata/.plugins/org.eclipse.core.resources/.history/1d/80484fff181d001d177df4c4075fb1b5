import java.io.*;
import java.util.*;

public class Main_백준_2839_설탕배달_S4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int temp = 0;
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		temp = n;
		while (temp >= 0) {
			if (temp % 3 == 0) {
				min = Math.min(temp / 3 + cnt, min);
			}
			temp -= 5;
			cnt++;
		}
		if (min != Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println(-1);
	}
}
