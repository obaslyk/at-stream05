package theme1;

public class Task5 {

    public static void main(String[] args) {

        System.out.println(blastOff(5));

    }

    public static String blastOff(int start) {

        String result = "";

        for (int i = start; i >= 1; i--) {
            result = result + i + " ";
        }
        return result + "Поехали!";
    }
}

