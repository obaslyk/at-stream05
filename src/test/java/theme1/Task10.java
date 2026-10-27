package theme1;

public class Task10 {
    public static void main(String[] args) {

        System.out.println(java.util.Arrays.toString(reverse(new String[]{"11", "22", "33", "44"})));

    }
    public static String[] reverse(String[] arr) {

        String[] result = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] =  arr[arr.length - 1 - i];

        }
        return result;
    }
}
