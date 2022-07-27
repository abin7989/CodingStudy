import java.util.Scanner;

public class SWEA_1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 수 만큼 반복
			String orig = sc.next(); // 메모리의 원래 값 입력
			int cnt = 0; // 수정 횟수
			
//			첫번째 1 나오는 인덱스 구하기
			int first_idx = 0;
			for (int i = 0; i < orig.length(); i++) {
				if (orig.charAt(i) != '0') {
					first_idx = i;
					cnt++;
					break;
				}
			}
			
			char pre = '1'; // 바뀌기 이전 문자
			// 원래 값으로 복구하기 위한 최소 수정 횟수 구하기
			for (int i = first_idx + 1; i < orig.length(); i++) {
				if (orig.charAt(i) == '0' && pre == '1') { // '1'에서 '0'으로 바뀌는 순간이라면
					cnt++; // 수정 횟수 + 1
					pre = '0'; // 이전 문자 '0'으로 바꾸기
				} else if (orig.charAt(i) == '1' && pre == '0') { // '0'에서 '1'으로 바뀌는 순간이라면
					cnt++; // 수정 횟수 + 1
					pre = '1'; // 이전 문자 '1'으로 바꾸기
				}
			}
			System.out.printf("#%d %d\n", tc, cnt); // 결과 출력
		}
	}

}
