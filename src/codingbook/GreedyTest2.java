package codingbook;

/**
 * PART 2 - CHAPTER 3
 * 96P 실전문제 - 숫자 카드 게임
 */
public class GreedyTest2 {

    public static void main(String[] args) {
//        int n = 3;
//        int m = 3;
//        int[][] arr = new int[][] {
//                {3, 1, 2},
//                {4, 1, 4},
//                {2, 2, 2}
//        };

        int n = 2;
        int m = 4;
        int[][] arr = new int[][] {
                {7, 3, 1, 8},
                {3, 3, 3, 4}
        };

        int result = solution1(n, m, arr);

        System.out.println(result);
    }

    public static int solution1(
            int n,
            int m,
            int[][] target
    ) {
        int result = 0;

        for (int i = 0; i < n; i++) {

            int minOfRow = 0;

            for (int j = 0; j < m; j++) {
                if (target[i][j] == 1) {
                    minOfRow = target[i][j];
                    break;
                }

                if (j == 0) {
                    minOfRow = target[i][j];
                }

                if (target[i][j] < minOfRow) {
                    minOfRow = target[i][j];
                }
            }

            if (result < minOfRow) {
                result = minOfRow;
            }
        }

        return result;
    }


}
