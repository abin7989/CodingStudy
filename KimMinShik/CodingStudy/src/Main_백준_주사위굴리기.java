import java.io.*;
import java.util.*;

public class Main_백준_주사위굴리기 {
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st;
		static StringBuilder sb  = new StringBuilder(1000);
		static int cubeSet[] = {1,4,3,2,5,6};
		static int cubeTop[] = {-1,6,5,4,3,2,1};
		static	 int cubeNum[] = new int [7];
		static int px;
		static int py;
		static int com;
		public static void main(String[] args) throws IOException {
			st = new StringTokenizer(br.readLine()," " );
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int px = Integer.parseInt(st.nextToken());
			int py = Integer.parseInt(st.nextToken());
			int com = Integer.parseInt(st.nextToken());
			int map[][] = new int [n][m];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine()," " );
				for(int j = 0 ; j < m ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine()," " );

			int temp;
			for(int i =0; i <com;i++) {
				int pos = Integer.parseInt(st.nextToken());
				switch (pos) {
				case 1:
					if(py+1>=m)
						continue;
					py++;
					
					temp = cubeSet[0];
					cubeSet[0] = cubeSet[2];
					cubeSet[2] = cubeSet[5];
					cubeSet[5] = cubeSet[1];
					cubeSet[1] = temp;
					break;
				case 2:
					//{1,4,3,2,5,6};
					if(py-1<0)
						continue;
					py--;
					temp = cubeSet[0];
					cubeSet[0] = cubeSet[1];
					cubeSet[1] = cubeSet[5];
					cubeSet[5] = cubeSet[2];
					cubeSet[2] = temp;
					break;
				case 3:
					if(px-1<0)
						continue;
					px--;
					//{1,4,3,2,5,6};
					temp = cubeSet[0];
					cubeSet[0] = cubeSet[3];
					cubeSet[3] = cubeSet[5];
					cubeSet[5] = cubeSet[4];
					cubeSet[4] = temp;
					break;
				case 4:
					if(px+1>=n)
						continue;
					px++;
					//{1,4,3,2,5,6};
					temp = cubeSet[0];
					cubeSet[0] = cubeSet[4];
					cubeSet[4] = cubeSet[5];
					cubeSet[5] = cubeSet[3];
					cubeSet[3] = temp;
					break;

				}
				if(map[px][py] == 0) {
					map[px][py] = cubeNum[cubeTop[cubeSet[0]]];
				}
				else {
					cubeNum[cubeTop[cubeSet[0]]] = map[px][py];
					map[px][py] = 0;
				}
				sb.append(cubeNum[cubeSet[0]]).append("\n");
			}
			System.out.println(sb);
		}
}


// 1 2 3 4 5 6
//         3
//           5
//   7
//     8
//   
//
//
//
//
//



















