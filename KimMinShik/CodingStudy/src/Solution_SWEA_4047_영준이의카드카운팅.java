

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4047_영준이의카드카운팅 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			String st = br.readLine();
			boolean pass = true;
			boolean[][] arr = new boolean[4][14];
			B:for(int i = 0; i < st.length();i+=3) {
				String temp = st.substring(i+1,i+3);
				int n = Integer.parseInt(temp);
				switch (st.charAt(i)) {
				case 'S':
					if(!arr[0][n]) {
						arr[0][n] =true;
					}else {
						pass =false;
						break B;
					}
					break;
				case 'D':
					if(!arr[1][n]) {
						arr[1][n] =true;
					}
					else {
						pass =false;
						break B;
					}
					break;
				case 'H':
					if(!arr[2][n]){
						arr[2][n] =true;
					}else {
						pass =false;
						break B;
					}
					break;
				case 'C':
					if(!arr[3][n]){
						arr[3][n] =true;
					}else {
						pass =false;
						break B;
					}
					break;
				default:
					break;
				}
				
			}
			System.out.printf("#%d ",test_case);
			if(pass) {
				for(int i = 0 ; i < 4;i++) {
					int cnt = 0;
					for(int j = 1; j < 14 ; j++) {
						if(arr[i][j])
							cnt++;
					}
					System.out.printf("%d ",13-cnt);
					
				
				}
				System.out.println();
			}else {
				System.out.println("ERROR");
			}
		}
	}
}
