package theme1;

public class Task9 {
    public static void main(String[] args) {

        System.out.println(findMax(new int[]{2, 15, 33, 55, 22, -66})); // 55
        System.out.println(findMax(new int[]{2, 15, 88})); //88
        System.out.println(findMax(new int[]{7})); //7

    }

    public static int findMax(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
