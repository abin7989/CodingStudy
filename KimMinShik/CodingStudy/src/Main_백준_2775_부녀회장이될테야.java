import java.io.*;
import java.util.*;

//Main_백준_2775_부녀회장이될테야
public class Main_백준_2775_부녀회장이될테야 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);

	public static void main(String[] args) throws NumberFormatException, IOException {
		int map[][] = new int[15][15];
		for (int j = 1; j < 15; j++) {
			map[0][j] += j;
			map[0][j] += map[0][j-1];
		}
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				map[i][j] += map[i-1][j];
				map[i][j] += map[i][j-1];
			}
		}
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i<t;i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(map[k][n]-map[k][n-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
