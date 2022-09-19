package Programmers;

// 2021 KAKAO BLIND RECRUITMENT - 신규 아이디 추천
public class New_id_recommend {
	
	public static void main(String[] args) {
		System.out.println(solution("abcdefghijklmn.p"));
	}
	
	public static String solution(String new_id) {
        String answer = "";
        
        // 1단계: 모든 대문자를 대응되는 소문자로 치환
        String result1 = new_id.toLowerCase();
        
        // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        StringBuilder result2 = new StringBuilder();
        char[] charArray1 = result1.toCharArray();
        for (char c: charArray1) {
        	if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
        		result2.append(c);
        	}
        }
        
        // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        String result3 = result2.toString();
        while (result3.contains("..")) {
        	result3 = result3.replace("..", ".");
        }
        
        // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
        String result4 = result3;
        if (result4.length() > 0) {
        	if (result4.charAt(0) == '.') {
        		result4 = result4.substring(1, result4.length());
        	}        	
        }
        if (result4.length() > 0) {
        	if (result4.charAt(result4.length() - 1) == '.') {
            	result4 = result4.substring(0, result4.length() - 1);
            }       	
        }
        
        
        // 5단계: 빈 문자열이라면, new_id에 "a"를 대입
        String result5 = result4;
        if (result5.length() == 0) {
        	result5 = "a";
        }
        
        // 6단계: 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        String result6 = result5;
        if (result6.length() >= 16) {
        	result6 = result6.substring(0, 15);
        	// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        	if (result6.charAt(result6.length() - 1) == '.') {
        		result6 = result6.substring(0, result6.length() - 1);
        	}
        }
        
        
        // 7단계: 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        String result7 = result6;
        if (result7.length() <= 2) {
        	char c = result7.charAt(result7.length() - 1);
        	while(result7.length() != 3) {
        		result7 += c;
        	}
        }
        
        answer = result7;
        
        return answer;
    }

}
