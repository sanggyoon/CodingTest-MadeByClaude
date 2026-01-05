public class Q20260105Test {
    public static void main(String[] args) {
        Q20260105 sol = new Q20260105();
        
        // 테스트 1
        int result1 = sol.solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println("테스트 1: " + result1 + " (예상: 1)");
        
        // 테스트 2
        int result2 = sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println("테스트 2: " + result2 + " (예상: 5)");
        
        // 테스트 3
        int result3 = sol.solution(new int[]{2, 1, 2, 1, 2}, 3);
        System.out.println("테스트 3: " + result3 + " (예상: 5)");
    }
}
