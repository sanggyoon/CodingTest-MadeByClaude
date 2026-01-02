import java.util.*;

public class Q20260102 {
    
    public static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i=0; i<s.length(); i++) {
            sb.append(sb.charAt(0));
            sb.delete(0, 1);
            if (isValidation(sb.toString())) {
                answer++;
            }
        }   
        return answer;
    }
    
    public static boolean isValidation(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            // 열린 괄호는 스택에 삽입
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) { // 닫힌 괄호인데 스택이 비었으면 false
                return false;
            } else if (c == ')' && stack.pop() != '(') { // 닫힌 괄호의 짝이 안 맞으면 false
                return false;
            } else if (c == ']' && stack.pop() != '[') {
                return false;
            } else if (c == '}' && stack.pop() != '{') {
                return false;
            }
        }
        // 최종 스택이 비었는지 확인
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution("[](){}"));  // 3
        System.out.println(solution("}]()[{"));  // 2
        System.out.println(solution("[)(]"));    // 0
        System.out.println(solution("}}}"));     // 0
    }
}
