package beakjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2798
 */
public class BlackJack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = search(arr, N, M);
        System.out.println(result);

    }

    private static int search(int[] arr, int n, int m) {
//        int cnt = 0;
        int result = 0;
        int sum = 0;
        for (int i = 0; i < n-2; i++) {
            for(int k = i+1; k < n-1; k++) {
                for(int j = k+1; j < n; j++) {
//                    cnt++;
                    sum = arr[i] + arr[k] + arr[j];
                    if(sum > m) continue;

                    if(i==0 && k==i+1 && j==k+1){
                        result = sum;
//                        System.out.printf("cnt: %d => i: %d, k: %d, j: %d , result: %d %n", cnt, i, k, j, result);
                        continue;
                    }
                    result = m-sum < m-result? sum : result;
//                    System.out.printf("cnt: %d => i: %d, k: %d, j: %d , result: %d %n", cnt, i, k, j, result);
                }
            }
        }
        return result;
    }
}
