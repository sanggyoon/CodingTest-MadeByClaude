import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Q20251231 {
    public static void main(String[] args) {
        // 전체 회의 개수 받기
        Scanner sc = new Scanner(System.in);
        System.out.println("전체 미팅 개수를 입력하세요");
        int NumberOfMeetings = sc.nextInt();
        sc.nextLine();

        // 엣지 케이스
        if (NumberOfMeetings == 0) {
            System.out.println("회의가 없습니다.");
            return;
        }
        // "00 00" 입력 받고 회의 시간 배열 만들기, 끝나는 시간이 시작시간 보다 빠른 오류는 고려하지 않음
        List<int[]> cases = new ArrayList<>();
        for (int i=0; i<NumberOfMeetings; i++) {
            System.out.printf("%d번째 미팅의 시작 시간과 끝나는 시간을 입력하세요", i+1);
            String[] input = sc.nextLine().split(" ");
            cases.add(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        // 끝나는 시간으로 오름차순 정렬
        Collections.sort(cases, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        // 다음 회의 시작시간이 이전 회의 끝나는 시간보다 크거나 같은 경우 카운트
        int count = 1;
        int lastEnd = cases.get(0)[1];
        for (int i=0; i<NumberOfMeetings-1; i++) {
            if (lastEnd <= cases.get(i+1)[0]) {
                count++;
                lastEnd = cases.get(i+1)[1];
            }
        }

        // 결과 출력
        System.out.println("결과: " + count);
    }
}