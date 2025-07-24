package codingbook;

/**
 * PART 2 - CHAPTER 3
 * 99P 실전문제 - 1이 될 때까지
 */
public class GreedyTest3 {

    public static void main(String[] args) {
        int n = 27;
        int m = 3;

        int result = solution1(n, m);

        System.out.println(result);
    }

    public static int solution1(
            int n,
            int m
    ) {
        int count = 0;

        while (n != 1) {
            if (n%m == 0) {
                n = n/m;
                count++;
            } else {
                n-=1;
                count++;
            }
        }

        return count;
    }


}
