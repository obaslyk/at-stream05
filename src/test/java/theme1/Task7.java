package theme1;

public class Task7 {
    public static void main(String[] args) {

        System.out.println(hasBug(new String[]{"pat", "Bug", "sun"}));
        System.out.println(hasBug(new String[]{"cat", "debug"}));
        System.out.println(hasBug(new String[]{}));

    }

    public static boolean hasBug(String[] messages) {
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].equalsIgnoreCase("Bug")) {
                return true;

            }

        }
        return false;
    }
}
