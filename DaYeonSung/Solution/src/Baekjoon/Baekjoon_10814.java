package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 10814. 나이순 정렬
public class Baekjoon_10814 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		User[] users = new User[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			users[i] = new User(age, name, i + 1);
		}
		
		Arrays.sort(users);
		
		for (User user : users) {
			sb.append(user.age).append(" ").append(user.name).append("\n");
		}
		
		System.out.println(sb);
	}

}

class User implements Comparable<User> {
	public int age;
	public String name;
	public int idx;
	
	public User(int age, String name, int idx) {
		this.age = age;
		this.name = name;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(User u) {
		if (this.age != u.age) {
			return this.age - u.age;
		} else {
			return this.idx - u.idx;
		}
	}
}
