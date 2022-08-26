package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 17478. 재귀함수가 뭔가요?
public class Baekjoon_17478 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 교수님이 출력을 원하는 재귀 횟수
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
				
		question(N);
		
		System.out.println(sb);
	}
	
	static String recurStr = "";
	private static void question(int N) {
		String str = recurStr;

		if (N == 0) {
			sb.append(str).append("\"재귀함수가 뭔가요?\"\n");
			sb.append(str).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(str).append("라고 답변하였지.\n");
			return;
		}
		// 재귀 종료 조건이 아니라면
		sb.append(str).append("\"재귀함수가 뭔가요?\"\n");
		sb.append(str).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(str).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(str).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		recurStr += "____";

		question(N - 1);

		sb.append(str).append("라고 답변하였지.\n");
	
	}

}
