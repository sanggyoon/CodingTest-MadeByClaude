import java.util.*;

public class Q20260116 {
  public static void main(String[] args) {
    
  }

  public static int[] solution(int[] answer) {
    int[] studentA = {1, 2, 3, 4, 5};
    int[] studentB = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] studentC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int[] point = new int[3];

    for (int i=0; i<answer.length; i++) {
      if (answer[i] == studentA[i % studentA.length]) {
        point[0]++;
      }
      if (answer[i] == studentB[i % studentB.length]) {
        point[1]++;
      }
      if (answer[i] == studentC[i % studentC.length]) {
        point[2]++;
      }
    }
    
    int maxPoint = 0;
    for (int i=0; i<3; i++) {
      if (point[i] > maxPoint) maxPoint = point[i];
    }

    List<Integer> list = new ArrayList<>();
    for (int i=0; i<3; i++) {
      if (point[i] == maxPoint) list.add(i+1);
    }

    return answer = list.stream().mapToInt(Integer::intValue).toArray();
  }
}
