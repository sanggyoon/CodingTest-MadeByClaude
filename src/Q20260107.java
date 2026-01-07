import java.util.*;

public class Q20260107 {
    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        // int K = sc.nextInt();
        

        // test case
        int[] scovile = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scovile, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        // 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        // 새로운 음식 만들고 다시 큐에 저장
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            int f1 = pq.poll();
            int f2 = pq.poll();
            int newFood = f1 + (f2 * 2);
            pq.offer(newFood);
            answer++;
        }

        return answer;
    }
}
