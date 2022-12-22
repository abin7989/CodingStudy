package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 백준 13915. 현수의 열기구 교실
public class Baekjoon_13915 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line;
		
		while((line = br.readLine()) != null && !line.equals("")) {
			ArrayList<int[]> lists = new ArrayList<>();
			int N = Integer.parseInt(line);
			
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> nums = new ArrayList<>();
				String str = br.readLine();
				int len = str.length();
				for (int j = 0; j < len; j++) {
					if (!nums.contains((int)(str.charAt(j) - '0'))) {
						nums.add((int)(str.charAt(j) - '0'));
					}
				}

				int[] arr = new int[nums.size()];
				for (int j = 0; j < nums.size(); j++) {
					arr[j] = nums.get(j);
				}
				
				Arrays.sort(arr);
				
				boolean flag = true;
				for (int j = 0; j < lists.size(); j++) {
					if (Arrays.equals(lists.get(j), arr)) flag = false;
				}
				
				if (flag) {
					lists.add(arr);
				}
			}
			
			
			sb.append(lists.size()).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
