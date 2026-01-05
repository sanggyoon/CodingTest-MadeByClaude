import java.util.*;

public class Q20260105 {
    public static void main(String[] args) {
        // Solution sol = new Solution();
        
        // // 테스트 1
        // int result1 = sol.solution(new int[]{2, 1, 3, 2}, 2);
        // System.out.println(result1); // 예상: 1
        
        // // 테스트 2
        // int result2 = sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        // System.out.println(result2); // 예상: 5
        
        // // 테스트 3
        // int result3 = sol.solution(new int[]{2, 1, 2, 1, 2}, 3);
        // System.out.println(result3); // 예상: 5
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 1부터 시작하는 인덱스 맵핑, 인덱스 순서대로 큐 생성
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=1; i<=priorities.length; i++){
            queue.offer(i);
            map.put(i, priorities[i-1]);
        }

        // 처음부터 바로 출력되는 것은 없으니 0
        int printNow = 0;
        int compareNow = 1;
        // 프린트되는 인덱스가 location이면 중지, 결과 반환
        while(printNow != location+1) {
            // 우선 순위가 가장 큰 지 판단
            boolean isMax = true;
            for (int q : queue) {
                if (map.get(compareNow) < map.get(q)) {
                    isMax = false;
                }
            }

            // 가장 크다면 프린트하고 차례 +1, 아니면 큐 뒤로 이동
            if (isMax) {
                answer++;
                printNow = queue.poll();
                compareNow = queue.peek();
            } else if (!isMax) {
                queue.offer(queue.poll());
                compareNow = queue.peek();
            }
        }

        return answer;
    }
}
