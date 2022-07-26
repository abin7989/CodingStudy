import java.io.*;
import java.util.*;
public class Main_백준_1010_다리놓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	public static void main(String[] args) throws NumberFormatException, IOException {
		int map[][]=new int [31][31];
		map[0][0] = 1;
		for(int i = 1 ; i < 31 ; i++) {
			map[i][0] = 1;
			map[i][i] = 1;
			for(int j = 1 ;j<i;j++) {
				map[i][j] = map[i-1][j]+map[i-1][j-1];
			}
		}
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(map[b][a]).append("\n");
		}
		System.out.println(sb);
	}
}
