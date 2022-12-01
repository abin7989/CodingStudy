import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 백준 1546. 평균
public class Baekjoon_1546 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		double[] grades = new double[N];
		
		double max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			grades[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, grades[i]);
		}
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			grades[i] = grades[i] / max * 100;
			sum += grades[i];
		}

		System.out.println(sum / grades.length);
	}

}
