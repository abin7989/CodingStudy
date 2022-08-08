import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N1 = Integer.valueOf(br.readLine()); // 원본 암호문의 길이

			ArrayList<Integer> list = new ArrayList<Integer>(); // 원본 암호문
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N1; i++) {
				list.add(Integer.valueOf(st.nextToken()));
			}

			int N2 = Integer.valueOf(br.readLine()); // 명령어의 개수
			String s = br.readLine();
			StringTokenizer st2 = new StringTokenizer(s);

			for (int i = 0; i < N2; i++) {
				if (st2.nextToken().equals("I")) {

					int x = Integer.parseInt(st2.nextToken()); // x위치 다음
					int y = Integer.parseInt(st2.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(x, Integer.parseInt(st2.nextToken()));
						x++;
					}
				}

			}
			
			sb.append("#").append(test_case).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
}
