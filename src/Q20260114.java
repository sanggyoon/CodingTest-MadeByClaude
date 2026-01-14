import java.util.*;

public class Q20260114 {
  public static void main(String[] args) {
    
  }

  public static int solution(int n, int[] lost, int[] reserve) {
    Set<Integer> lostSet = new HashSet();
    Set<Integer> reserveSet = new HashSet();

    for (int l : lost) lostSet.add(l);
    for (int r : reserve) reserveSet.add(r);

    for (int i=0; i<lost.length; i++) {
      int t = lost[i];
      if (reserveSet.contains(t) && lostSet.contains(t)) {
        lostSet.remove(t);
        reserveSet.remove(t);
      }
    }
    for (int i=0; i<lost.length; i++) {
      int t = lost[i];
      if (reserveSet.contains(t - 1) && lostSet.contains(t)) {
        lostSet.remove(t);
        reserveSet.remove(t - 1);
      } else if (reserveSet.contains(t + 1) && lostSet.contains(t)) {
        lostSet.remove(t);
        reserveSet.remove(t + 1);
      }
    }

    return n - lostSet.size();
  }
}
