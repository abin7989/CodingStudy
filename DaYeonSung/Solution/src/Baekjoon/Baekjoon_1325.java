package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 백준 1325. 효율적인 해킹
public class Baekjoon_1325 {

	public static List<Integer>[] list;
    public static int[] cnt;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        list = new ArrayList[N + 1];

        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            String[] data = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            list[a].add(b);

        }

        cnt = new int[N + 1];

        for(int i = 1; i <= N; i++){
        	letsHack(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int max_value = 0;
        for(int i = 1;i <= N; i++){
            if(cnt[i] > max_value){
                max_value = cnt[i];
                ans.clear();
                ans.add(i);
            } else if (cnt[i] == max_value){
                ans.add(i);
            }
        }

        for(int a:ans){
            System.out.print(a+" ");
        }


    }
	
	private static void letsHack(int start) {
		 boolean[] visited = new boolean[N + 1];
	        Queue<Integer> q = new LinkedList<>();
	        visited[start] = true;
	        q.offer(start);

	        while (!q.isEmpty()) {
	            int x = q.poll();
	            for (int num : list[x]) {
	                if (!visited[num]) {
	                    cnt[num]++;
	                    visited[num] = true;
	                    q.offer(num);
	                }
	            }
	        }

	}

}
