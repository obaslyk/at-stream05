package theme1;

public class Task2 {

    public static void main(String[] args) {

        System.out.println(checkAccess(-25));
        System.out.println(checkAccess(36));
        System.out.println(checkAccess(18));

    }

    public static String checkAccess(int age) {

        if (age > 18) {
            return "Allowed";
        } else {
            return "Denied";
        }
    }

}
