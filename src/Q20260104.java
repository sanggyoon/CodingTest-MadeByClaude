import java.util.*;

public class Q20260104 {
    public static void main(String[] args) {

    }
    // 문제
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<progresses.length; i++) {
            int cal = (100 - progresses[i]) % speeds[i];
            if (cal == 0) {
                queue.offer((100 - progresses[i]) / speeds[i]);
            } else {
                queue.offer((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int term = queue.peek();
        int count = 0;
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            if (queue.peek() <= term) {
                count++;
                queue.poll();
            } else {
                list.add(count);
                term = queue.peek();
                count = 0;
            }
        }
        list.add(count);
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
