package algorithms;

public class TopOfHanoi {
    public static void main(String[] args) {
        move(3, 1, 3);
    }

    // n : 원반갯수
    private static void move(int n, int x, int y) {
        if(n > 1) move(n-1, x, 6-x-y);

        System.out.println(String.format("원반 [%d] 을 [%d번]에서 [%d번]으로 옮긴다.", n, x, y));

        if(n > 1) move(n-1, 6-x-y, y);
    }
}
