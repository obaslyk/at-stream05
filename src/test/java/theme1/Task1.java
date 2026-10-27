package theme1;

public class Task1 {

    public static void main(String[] args) {
        System.out.println(isEven(4));
        System.out.println(isEven(7));
        System.out.println(isEven(0));
    }

    public static boolean isEven(int n) {

        if ((n % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }
}

