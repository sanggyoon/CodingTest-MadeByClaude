import java.util.*;

public class Q20260108 {
    public static void main(String[] args) {

    }

    public static int solution(int[][] jobs) {
    // 1. 요청 시간 기준으로 정렬
    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
    
    // 2. 소요 시간 기준으로 정렬하는 우선순위 큐
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    
    int currentTime = 0;
    int index = 0;  // jobs 배열의 현재 인덱스
    int totalWaitTime = 0;
    int count = 0;  // 완료된 작업 수
    
    while (count < jobs.length) {
        // 현재 시간에 처리 가능한 작업들을 큐에 추가
        while (index < jobs.length && jobs[index][0] <= currentTime) {
            pq.offer(jobs[index]);
            index++;
        }
        
        if (!pq.isEmpty()) {
            // 소요시간이 가장 짧은 작업 처리
            int[] job = pq.poll();
            currentTime += job[1];  // 작업 완료 시간
            totalWaitTime += (currentTime - job[0]);  // 대기시간 누적
            count++;
        } else {
            // 처리 가능한 작업이 없으면 다음 작업의 요청 시간으로 점프
            currentTime = jobs[index][0];
        }
    }
    
    return totalWaitTime / jobs.length;
}
}