import java.util.*;

public class Q20260110 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        // List<Integer> list = new ArrayList<>();
        // for (int p : people) list.add(p);
        // Collections.sort(list);

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else if (people[right] <= limit){
                right--;
            }
            answer++;
        }
        
        return answer;
    }
}
