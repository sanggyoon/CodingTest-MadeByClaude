public class Q20260109 {
    public static void main(String[] args) {
        System.out.println("test1:" + solution(1260));
        System.out.println("test2:" + solution(4570));
    }
    
    public static int solution(int change) {
        int result = 0;
        int[] coins = {500, 100, 50, 10};

        for (int coin : coins) {
            result += change / coin;
            change %= coin;
        }
        return result;
    }
}
