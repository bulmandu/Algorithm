package codingbook;

/**
 * PART 2 - CHAPTER 3
 * 92P 실전문제 - 큰수의 법칙
 */
public class GreedyTest1 {

    public static void main(String[] args) {
        int[] condition = new int[] {5, 8, 3};
        int[] arr = new int[] {2, 4, 5, 4, 6};

        int result = solution2(condition, arr);
        System.out.println(result);
    }

    // 2. 92P 실전문제 - 큰수의 법칙
    public static int solution1(
            int[] condition,
            int[] arr
    ) {
        int result = 0;

        int first = 0;
        int second = 0;

        for (int number : arr) {
            if (first < number) {
                second = first;
                first = number;
                continue;
            }

            if (second < number) {
                second = number;
            }
        }

        int count = 0;

        for (int i = 0; i < condition[1]; i++) {
            if (count == condition[2]) {
                result+=second;
                count = 0;
                continue;
            }

            result+=first;
            count++;
        }

        return result;
    }

    public static int solution2(
            int[] condition,
            int[] arr
    ) {
        int first = 0;
        int second = 0;

        for (int number : arr) {
            if (first < number) {
                second = first;
                first = number;
                continue;
            }

            if (second < number) {
                second = number;
            }
        }

        int cycle = condition[1]/(condition[2]+1);
        int reminder = condition[1]%(condition[2]+1);
        int cycleSum = first*condition[2] + second;

        return cycleSum*cycle + reminder*first;
    }
}
