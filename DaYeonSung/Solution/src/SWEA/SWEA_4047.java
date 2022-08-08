package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 4047. 영준이의 카드 카운팅
public class SWEA_4047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String str = br.readLine(); // 문자열 입력받기
			int cnt_S = 13;
			int cnt_D = 13;
			int cnt_H = 13;
			int cnt_C = 13;
			
			boolean flag = true;
			int num = str.length() / 3;
			String[] arr = new String[num];
			int idx = 0;
			for (int start = 0, end = 3; end <= str.length(); start += 3, end += 3) {
				arr[idx++] = str.substring(start, end);
			}
//			겹치는 카드 있는지 확인
			for (int i = 0; i < num; i++) {
				for (int j = i+1; j < num; j++) {
					if (arr[i].equals(arr[j])) {
						sb.append("ERROR\n");
						flag = false;
					}
				}
			}
//			겹치는 카드 있으면 더이상 진행 X
			if (flag == false) continue;
			
//			첫번째 글자로 카드 갯수 추정하기
			for (int i = 0; i < num; i++) {
				switch(arr[i].charAt(0)) {
					case 'S':
						cnt_S -= 1;
						break;
					case 'D':
						cnt_D -= 1;
						break;
					case 'H':
						cnt_H -= 1;
						break;
					case 'C':
						cnt_C -= 1;
						break;
				}
			}
			
			sb.append(cnt_S).append(" ").append(cnt_D).append(" ").append(cnt_H).append(" ").append(cnt_C).append("\n");
		}
		System.out.println(sb);
	}

}
