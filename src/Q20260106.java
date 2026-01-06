import java.util.*;
public class Q20260106 {
    public static void main(String[] args) {

    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            int s = count.getOrDefault(genres[i],0 );
            count.put(genres[i], s + plays[i]);

            int[] song = new int[] {i, plays[i]};
            List<int[]> list = songs.getOrDefault(genres[i], new ArrayList<>());
            list.add(song);
            Collections.sort(list, (a, b) -> {
                return Integer.compare(b[1], a[1]);
            });
            songs.put(genres[i], list);
        }
        
        List<String> t = new ArrayList<>(count.keySet());
        t.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return count.get(o2).compareTo(count.get(o1));
            }
        });

        List<Integer> answer = new ArrayList<>();
        for (String s : t) {
            answer.add(songs.get(s).get(0)[0]);
            if (songs.get(s).size() >= 2){
                answer.add(songs.get(s).get(1)[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
