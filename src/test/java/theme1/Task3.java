package theme1;

public class Task3 {

    public static void main(String[] args) {

        System.out.println(isPositive(0));
        System.out.println(isPositive(-9));
        System.out.println(isPositive(35));
    }

    public static boolean isPositive(int n) {
        return (n >= 0) ? true : false;
    }
}


