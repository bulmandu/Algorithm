package codingbook;

/**
 * PART 2 - CHAPTER 3
 */
public class Greedy {

    public static void main(String[] args) {
        int result = greedy(1260);
        System.out.println(result);
    }

    // 1. 87P 예제 3-1
    public static int greedy(int money) {
        int[] coins = new int[] {500, 100, 50, 10};

        int count = 0;
        int changeMoney = money;

        for (int coin : coins) {
            count += changeMoney/coin;
            changeMoney %= coin;
        }

        return count;
    }
}
