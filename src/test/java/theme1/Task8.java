package theme1;

public class Task8 {
    public static void main(String[] args) {

        System.out.println(getEvenInRange(2, 15));
        System.out.println(getEvenInRange(0, 10));
        System.out.println(getEvenInRange(-5, 3));
        System.out.println(getEvenInRange(2, 15));

    }

    public static String getEvenInRange(int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            if ((i % 2) == 0) {
                if (!result.isEmpty()) {
                    result = result + " ";
                }
                result = result + i;
            }
        }
        return result;

    }
}



